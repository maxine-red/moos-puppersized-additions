#!/usr/bin/env ruby

require 'json'

mod = 'strawberrytwirl'

data = JSON.parse(File.read(File.dirname(__FILE__) + '/integration.json'))
dir = "#{File.dirname(__FILE__)}/src/main/resources/data/#{mod}/recipes/integration"
dir.split('/').each do |d|
  Dir.mkdir(d) unless File.directory?(d)
  Dir.chdir(d)
end
data.each do |k, v|
  Dir.mkdir(k) unless File.exists?(k)
  Dir.chdir(k) do
    recipe = {conditions: [{type: 'forge:mod_loaded', modid: 'create'}]}
    v.each do |m, d|
      Dir.mkdir(m) unless File.exists?(m)
      Dir.chdir(m) do
        recipe.store(:type, "#{k}:#{m}")
        d.each do |i|
          rec = recipe.dup
          if m == 'filling'
            rec.store(:ngredientss, [{fluid: "#{mod}:#{i}", amount: 250}, {item: 'minecraft:glass_bottle'}])
            rec.store(:results, [{item: "#{mod}:#{i}_bottle"}])
          elsif m == 'emptying'
            rec.store(:ingredients, [{item: "#{mod}:#{i}_bottle"}])
            rec.store(:results, [{fluid: "#{mod}:#{i}", amount: 250}, {item: 'minecraft:glass_bottle'}])
          end
          File.write("#{i}.json", JSON.pretty_generate(rec))
        end
      end
    end
  end
end
