package com.advent.of.code.day6;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FishSchool {
    private List<Fish> fishes;

    public FishSchool(String fishesCounters) {
        this.fishes = Stream.of(fishesCounters.split(","))
                .map(item -> new Fish(Integer.parseInt(item)))
                .collect(Collectors.toList());
    }

    public FishSchool simulateOverTime(int maxDays) {
        for (int actDay = 1; actDay <= maxDays; actDay++) {
            int initialSize = fishes.size();
            for (int i = 0; i < initialSize; i++) {
                Fish fish = fishes.get(i);
                if (fish.decreaseCount()) {
                    fishes.add(new Fish(8));
                }
            }
        }
        return this;
    }

    public long countFishes() {
        return fishes.size();

    }
}
