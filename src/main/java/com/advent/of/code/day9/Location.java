package com.advent.of.code.day9;

public class Location {
    private int x;
    private int y;
    private int height;
    private int riskLevel;

    public Location(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.riskLevel = height + 1;
    }

    public int getRiskLevel() {
        return riskLevel;
    }
}
