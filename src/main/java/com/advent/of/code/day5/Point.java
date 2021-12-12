package com.advent.of.code.day5;

import java.util.Objects;

public class Point {
    public int x;
    public int y;

    public Point(String[] vals) {
        this.x = Integer.parseInt(vals[0]);
        this.y = Integer.parseInt(vals[1]);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}