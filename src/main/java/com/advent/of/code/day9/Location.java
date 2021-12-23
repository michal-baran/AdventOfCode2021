package com.advent.of.code.day9;

public class Location {
    private final int y;
    private final int x;
    private final int height;
    private final int riskLevel;
    private boolean visited = false;

    public Location(int y, int x, char value) {
        this.y = y;
        this.x = x;
        this.height = Integer.parseInt(String.valueOf(value));
        this.riskLevel = height + 1;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public int getHeight() {
        return height;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited() {
        this.visited = true;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}