package com.advent.of.code.day6;

public class FishSchool {
    private long[] fishes = new long[9];

    public FishSchool(String inputString) {
        for (String value : inputString.split(",")) {
            fishes[Integer.parseInt(value)]++;
        }
    }

    public FishSchool simulateOverTime(int maxDays) {
        for (int actDay = 1; actDay <= maxDays; actDay++) {
            long newFishes = 0;
            for (int i = 0; i < fishes.length - 1; i++) {
                if (i == 0) {
                    newFishes = fishes[0];
                }
                fishes[i] = fishes[i + 1];
            }
            fishes[6] += newFishes;
            fishes[8] = newFishes;
        }
        return this;
    }

    public long countFishes() {
        long result = 0;
        for (long fishCount : fishes) {
            result += fishCount;
        }
        return result;
    }
}
