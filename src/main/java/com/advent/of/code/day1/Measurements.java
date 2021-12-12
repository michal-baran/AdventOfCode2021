package com.advent.of.code.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

public class Measurements {
    public static List<Integer> generate(String filename) {
        List<Integer> resultList = new ArrayList<>();
        final String path = FileSystems.getDefault().getPath("").toAbsolutePath().toString().concat("\\src\\main\\java\\day1\\" + filename);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                resultList.add(Integer.parseInt(currentLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }
}
