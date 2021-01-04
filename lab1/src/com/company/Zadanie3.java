package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Zadanie3
{
    private String _filePath;

    public Zadanie3(String filePath)
    {
        _filePath = filePath;
    }

    public long GetUniqueWordCount() throws IOException
    {
        return Files.lines(Paths.get(_filePath))
                .flatMap(x -> Arrays.stream(x.toLowerCase().split("\\W+")))
                .filter(x -> x.length() >= 3)
                .distinct()
                .count();
    }
}
