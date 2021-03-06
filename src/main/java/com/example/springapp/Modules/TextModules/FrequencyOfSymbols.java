package com.example.springapp.Modules.TextModules;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

@Component
public class FrequencyOfSymbols extends AbstractTextModule{
    @Override
    public String getFunctionDescription() {
        return "Возвращает все символы и их количество.";
    }

    @Override
    public void function(File file) {
        List<String> lines;
        try{
            lines = Files.readAllLines(file.toPath());
        }
        catch (IOException e){
            System.out.println("Не удалось прочитать файл " + file.getAbsolutePath());
            return;
        }

        HashMap<Character, Integer> symbols = lines.stream()
                .flatMapToInt(String::chars)
                .mapToObj(x -> (char)x)
                .collect(HashMap::new, (m, c) ->m.put(c, m.getOrDefault(c, 0)+1), HashMap::putAll);

        if (symbols.keySet().size() == 0){
            System.out.println("Файл пустой");
        }
        else {
            symbols.entrySet()
                    .stream()
                    .sorted((x, y) -> y.getValue().compareTo(x.getValue()))
                    .map(pair -> pair.getKey() + ": " + pair.getValue())
                    .forEach(System.out::println);
        }
    }
}
