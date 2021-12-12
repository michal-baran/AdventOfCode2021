package com.advent.of.code.day7;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CrabSubmarines {
    List<Integer> horizontalPositions;
    int minValue = Integer.MAX_VALUE;
    int maxValue = Integer.MIN_VALUE;

    public CrabSubmarines(String inputData) {
        horizontalPositions = Stream.of(inputData.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        getMinMax();
    }

    public int getOptimumFuel() {
        int optimumFuel = Integer.MAX_VALUE;
        for (int i = minValue; i <= maxValue; i++) {
            int fuelForPosition = 0;
            for (Integer value : horizontalPositions) {
                fuelForPosition += factorial(Math.abs(value - i));
            }
            if (fuelForPosition < optimumFuel) {
                optimumFuel = fuelForPosition;
            }
        }
        return optimumFuel;
    }

    private void getMinMax() {
        for (Integer value : horizontalPositions) {
            if (value < minValue) {
                minValue = value;
            }
            if (value > maxValue) {
                maxValue = value;
            }
        }
    }

    private long factorial(int value) {
        long sum = 0;
        for (int i = 1; i <= value; i++) {
            sum += i;
        }
        return sum;
    }
}