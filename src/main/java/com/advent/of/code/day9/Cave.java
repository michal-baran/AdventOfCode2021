package com.advent.of.code.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cave {
    private final int[][] heightMap;
    List<Location> locations = new ArrayList<>();

    public Cave(List<String> inputData) {
        this.heightMap = new int[inputData.size() + 2][inputData.get(0).length() + 2];
        Arrays.stream(heightMap).forEach(a -> Arrays.fill(a, 9));

        for (int i = 0; i < inputData.size(); i++) {
            for (int j = 0; j < inputData.get(i).length(); j++) {
                this.heightMap[i + 1][j + 1] = Integer.parseInt(inputData.get(i).substring(j, j + 1));
            }
        }
    }

    public Cave findLocations() {
        for (int i = 1; i < heightMap.length - 1; i++) {
            for (int j = 1; j < heightMap[i].length - 1; j++) {
                int heightAtLocation = heightMap[i][j];
                if ((heightAtLocation < heightMap[i - 1][j]) &&
                        (heightAtLocation < heightMap[i - 1][j - 1]) &&
                        (heightAtLocation < heightMap[i][j - 1]) &&
                        (heightAtLocation < heightMap[i + 1][j]) &&
                        (heightAtLocation < heightMap[i + 1][j + 1]) &&
                        (heightAtLocation < heightMap[i][j + 1])) {
                    locations.add(new Location(i, j, heightAtLocation));
                }
            }
        }
        return this;
    }

    public Integer getRiskLevelsSum() {
        System.out.println("Low points count: " + locations.size());
        return locations.stream().map(Location::getRiskLevel).mapToInt(Integer::intValue).sum();
    }
}
