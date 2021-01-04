package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Zadanie4
{
    private String _filePath;

    public Zadanie4(String filePath)
    {
        _filePath = filePath;
    }

    public static Map<String, Integer> SortByValue(final Map<String, Integer> wordCounts)
    {
        return wordCounts.entrySet().stream().sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public void GetMostFrequentWords() throws IOException
    {
        Map<String, Integer> words = new HashMap<>();

        Files.lines(Paths.get(_filePath))
            .flatMap(x -> Arrays.stream(x.toLowerCase().split("\\W+")))
            .filter(x -> x.length() >= 3)
            .forEach(x ->
            {
                if (words.containsKey(x))
                {
                    words.put(x, words.get(x) + 1);
                }
                else
                {
                    words.put(x, 1);
                }
            });

        int iterator = 0;

        for (Map.Entry<String, Integer> entry : SortByValue(words).entrySet())
        {
            System.out.println(entry.getKey() + " " + entry.getValue());

            if (++iterator == 8) break;
        }
    }
}
