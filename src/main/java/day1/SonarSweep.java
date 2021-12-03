package day1;

import java.util.List;

public class SonarSweep {
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
        List<Integer> measurements = Measurements.generate("input.txt");
        System.out.println(countIncreases(measurements));
        System.out.println(slidingWindow(measurements));
    }
}