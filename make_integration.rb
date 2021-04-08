#!/usr/bin/env ruby

require 'json'

mod = 'strawberrytwirl'
pwd = File.expand_path(File.dirname(__FILE__))
Dir.chdir(pwd)
data = JSON.parse(File.read('integration.json'))
dir = "src/main/resources/data/#{mod}/recipes/integration"
dir.split('/').each do |d|
  Dir.mkdir(d) unless File.directory?(d)
  Dir.chdir(d)
end
data.each do |k, v|
  Dir.mkdir(k) unless File.exists?(k)
  Dir.chdir(k) do
    recipe = {conditions: [{type: 'forge:mod_loaded', modid: k}]}
    v.each do |m, d|
      Dir.mkdir(m) unless File.exists?(m)
      Dir.chdir(m) do
        recipe.store(:type, "#{k}:#{m}")
        d.each do |i|
          rec = recipe.dup
          if m == 'filling'
            rec.store(:ingredients, [{fluid: "#{mod}:#{i}", amount: 250}, {item: 'minecraft:glass_bottle'}])
            rec.store(:results, [{item: "#{mod}:#{i}_bottle"}])
          elsif m == 'emptying'
            rec.store(:ingredients, [{item: "#{mod}:#{i}_bottle"}])
            rec.store(:results, [{fluid: "#{mod}:#{i}", amount: 250}, {item: 'minecraft:glass_bottle'}])
          elsif m == 'compacting'
            rec.store(:ingredients, [{item: "minecraft:#{i[1]}"}]* i[2])
            rec.store(:results, [{fluid: "#{mod}:#{i[0]}", amount: 1000}])
            i = i.first
          elsif m == 'mixing'
            ingredients = []
            ingredients << {fluid: "#{mod}:#{i.sub('jam', 'juice').sub('_from_honey', '')}", amount: 500}
            if i.match('_from_honey')
              ingredients << {fluid: "create:honey", amount: 250}
            else
              3.times do
                ingredients << {item: 'minecraft:sugar'}
              end
            end
            rec.store(:ingredients, ingredients)
            rec.store(:results, [{fluid: "#{mod}:#{i.sub('_from_honey', '')}", amount: 250}])
            rec.store(:heatRequirement, 'heated')
          elsif m == 'cooking'
            ingredients = []
            2.times do
              ingredients << {item: "#{mod}:#{i.sub('jam', 'juice').sub('_from_honey', '')}_bottle"}
            end
            if i.match('_from_honey')
                ingredients << {item: 'minecraft:honey_bottle'}
            else
              3.times do 
                ingredients << {item: 'minecraft:sugar'}
              end
            end
            rec.store(:ingredients, ingredients)
            rec.store(:result, {item: "#{mod}:#{i.sub('_from_honey', '')}_bottle"})
            rec.store(:container, {item: 'minecraft:glass_bottle'})
            rec.store(:cookingtime, 100)
          end
          File.write("#{i}.json", JSON.pretty_generate(rec))
        end
      end
    end
  end
end
['create'].each do |omod|
  Dir.chdir(pwd)
  dir = "src/main/resources/data/#{omod}/tags"
  dir.split('/').each do |d|
    Dir.mkdir(d) unless File.directory?(d)
    Dir.chdir(d)
  end
  tags = {replace: false, values: []}
  if omod == 'create'
    Dir.mkdir('items') unless File.directory?('items')
    Dir.chdir('items')
    tags[:values] += data[omod]['filling'].map{|x|"#{mod}:#{x}_bottle"}
    File.write('upright_on_belt.json', JSON.pretty_generate(tags))
  end
end
