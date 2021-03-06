package com.advent.of.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<String> readInput(String filename) {
        List<String> resultList = new ArrayList();
        final String path = FileSystems.getDefault().getPath("").toAbsolutePath().toString().concat("\\src\\main\\resources\\" + filename);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                resultList.add(currentLine);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    public static String readLine(String filename) {
        String resultLine;
        final String path = FileSystems.getDefault().getPath("").toAbsolutePath().toString().concat("\\src\\main\\resources\\" + filename);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            resultLine = bufferedReader.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultLine;
    }
}
