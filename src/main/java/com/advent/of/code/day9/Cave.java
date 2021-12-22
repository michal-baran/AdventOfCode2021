package com.advent.of.code.day9;

import java.util.*;

public class Cave {
    private Location[][] locations;
    private List<Location> lowLocations = new ArrayList<>();
    private Map<Location, List<Location>> basins = new HashMap<>();
    private Location actualCheckedBasin;

    public Cave(List<String> inputData) {
        locations = new Location[inputData.size()][inputData.get(0).length()];
        for (int row = 0; row < inputData.size(); row++) {
            for (int column = 0; column < inputData.get(row).length(); column++) {
                locations[row][column] = new Location(row, column, inputData.get(row).charAt(column));
            }
        }
        setLowLocations();
        setBasins();
    }

    private void setLowLocations() {
        int[][] arr = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int y = 0; y < locations.length; y++) {
            for (int x = 0; x < locations[y].length; x++) {
                boolean isLow = true;
                for (int[] values : arr) {
                    int y1 = y + values[0];
                    int x1 = x + values[1];
                    if (y1 >= 0 && y1 < locations.length && x1 >= 0 && x1 < locations[y].length) {
                        Location checkedLocation = locations[y + values[0]][x + values[1]];
                        if (locations[y][x].getHeight() > checkedLocation.getHeight()) {
                            isLow = false;
                        }
                    }
                }
                if (isLow) {
                    lowLocations.add(locations[y][x]);
                }
            }
        }
    }

    private void setBasins() {
        for (Location location : lowLocations) {
            actualCheckedBasin = location;
            basins.put(actualCheckedBasin, new ArrayList<>());
            setBasinFromLocation(location);
        }
    }

    private void setBasinFromLocation(Location location) {
        int[][] arr = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int y = location.getY();
        int x = location.getX();

        for (int[] values : arr) {
            int y1 = y + values[0];
            int x1 = x + values[1];
            if (y1 >= 0 && y1 < locations.length && x1 >= 0 && x1 < locations[y].length) {
                Location checkedLocation = locations[y1][x1];

                if (checkedLocation.getHeight() < 9 && !checkedLocation.isVisited()) {
                    checkedLocation.setVisited();
                    basins.get(actualCheckedBasin).add(checkedLocation);
                    setBasinFromLocation(checkedLocation);
                }
            }
        }
    }

    public Integer getRiskLevelsSum() {
        return lowLocations.stream().map(Location::getRiskLevel).mapToInt(Integer::intValue).sum();
    }

    public Integer getLargestBasinsSize() {
        int[] basinSizes = new int[basins.size()];
        int result = 1;
        int i = 0;
        for (Map.Entry<Location, List<Location>> entry : basins.entrySet()) {
            basinSizes[i] = entry.getValue().size();
            i++;
        }
        Arrays.sort(basinSizes);

        for (int j = basins.size() - 1; j > basins.size() - 4; j--) {
            result *= basinSizes[j];
        }
        return result;
    }
}