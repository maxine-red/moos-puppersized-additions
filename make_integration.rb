#!/usr/bin/env ruby

require 'json'

data = JSON.parse(File.read(File.dirname(__FILE__) + '/integration.json'))
Dir.chdir(File.dirname(__FILE__)) do
  Dir.chdir('src/main/resources/data/strawberrytwirl/recipes') do 
    Dir.mkdir('integration') unless File.exists?('integration')
    Dir.chdir('integration') do
      data.each do |k, v|
        Dir.mkdir(k) unless File.exists?(k)
        Dir.chdir(k) do
          recipe = {conditions: [{type: 'forge:mod_loaded', modid: 'create'}]}
          v.each do |m, d|
            Dir.mkdir(m) unless File.exists?(m)
            Dir.chdir(m) do
              recipe.store(:type, "#{k}:#{m}")
              d.each do |r|
                rec = recipe.dup
                r.each do |key, value|
                  next if key == 'name'
                  rec.store(key, value)
                end
                File.write(r['name'], JSON.pretty_generate(rec))
              end
            end
          end
        end
      end
    end
  end
end
