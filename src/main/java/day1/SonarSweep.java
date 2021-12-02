package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SonarSweep {
    public static List<Integer> generateListFromFile(String file) {
        List<Integer> resultList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                resultList.add(Integer.parseInt(currentLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public static int countIncreases(List<Integer> measurements) {
        int increases = 0;
        for (int i = 0; i < measurements.size() - 1; i++) {
            if (measurements.get(i) < measurements.get(i + 1)) {
                increases++;
            }
        }
        return increases;
    }

    public static int slidingWindow(List<Integer> measurements) {
        int increases = 0;
        for (int i = 0; i < measurements.size() - 3; i++) {
            int common = measurements.get(i + 1) + measurements.get(i + 2);
            int window1 = measurements.get(i) + common;
            int window2 = common + measurements.get(i + 3);
            if (window1 < window2) {
                increases++;
            }
        }
        return increases;
    }

    public static void main(String[] args) {
        List<Integer> measurements = generateListFromFile("D:\\4. PROGRAMOWANIE\\Java\\Projekty\\AdventOfCode2021\\src\\main\\java\\day1\\input.txt");
        System.out.println(countIncreases(measurements));
        System.out.println(slidingWindow(measurements));
    }
}
