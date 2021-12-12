package com.advent.of.code.day5;

import com.advent.of.code.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        List<String> inputData = Utils.readInput("day5\\input.txt");
        Map<Point, Point> lines = getLines(inputData);
        Map<Point, Integer> points = getPointsStage1(lines);
        System.out.println(getResult(points));
        points = getPointsStage2(lines);
        System.out.println(getResult(points));
    }

    private static Map<Point, Point> getLines(List<String> inputData) {
        Map<Point, Point> result = new HashMap<>();
        for (String s : inputData) {
            String[] linePoints = s.split(" -> ");
            String[] point1 = linePoints[0].split(",");
            String[] point2 = linePoints[1].split(",");
            result.put(new Point(point1), new Point(point2));
        }
        return result;
    }

    private static Map<Point, Integer> getPointsStage1(Map<Point, Point> lines) {
        Map<Point, Integer> result = new HashMap<>();
        for (Map.Entry<Point, Point> line : lines.entrySet()) {
            Point p1 = line.getKey();
            Point p2 = line.getValue();
            if (p1.y == p2.y) {
                for (int i = Math.min(p1.x, p2.x); i <= Math.max(p1.x, p2.x); i++)
                    result.merge(new Point(i, p1.y), 1, Integer::sum);
            } else if (p1.x == p2.x) {
                for (int i = Math.min(p1.y, p2.y); i <= Math.max(p1.y, p2.y); i++)
                    result.merge(new Point(p1.x, i), 1, Integer::sum);
            }
        }
        return result;
    }

    private static Map<Point, Integer> getPointsStage2(Map<Point, Point> lines) {
        Map<Point, Integer> result = new HashMap<>();

        for (Map.Entry<Point, Point> line : lines.entrySet()) {
            Point p1 = line.getKey();
            Point p2 = line.getValue();
            if (p1.y == p2.y) {
                for (int i = Math.min(p1.x, p2.x); i <= Math.max(p1.x, p2.x); i++)
                    result.merge(new Point(i, p1.y), 1, Integer::sum);
            } else if (p1.x == p2.x) {
                for (int i = Math.min(p1.y, p2.y); i <= Math.max(p1.y, p2.y); i++)
                    result.merge(new Point(p1.x, i), 1, Integer::sum);
            } else {
                int xDir = p2.x - p1.x > 0 ? 1 : -1;
                int yDir = p2.y - p1.y > 0 ? 1 : -1;
                for (int i = 0; i <= Math.abs(p2.x - p1.x); i++)
                    result.merge(new Point(p1.x + (xDir * i), p1.y + (yDir * i)), 1, Integer::sum);
            }
        }
        return result;
    }

    private static long getResult(Map<Point, Integer> points) {
        int count = 0;
        for (int crossTimes : points.values()) {
            if (crossTimes > 1) {
                count++;
            }
        }
        return (count);
    }
}