package day2;

import java.util.List;

public class Submarine {
    public static void main(String[] args) {
        List<String> course = CoursePlan.generate("input.txt");
        System.out.println(calculatePosition(course));
        System.out.println(calculatePositionWithAim(course));
    }

    public static int calculatePosition(List<String> course) {
        int[] coordinates = new int[2];
        for (String s : course) {
            String[] commands = s.split(" ");
            int units = Integer.parseInt(commands[1]);
            switch (commands[0]) {
                case "forward" -> coordinates[0] += units;
                case "down" -> coordinates[1] += units;
                case "up" -> coordinates[1] -= units;
                default -> System.out.println("Unrecognized command");
            }
        }
        return coordinates[0] * coordinates[1];
    }

    public static int calculatePositionWithAim(List<String> course) {
        int[] coordinates = new int[3]; // 0-horizontal, 1-depth, 2-aim
        for (String s : course) {
            String[] commands = s.split(" ");
            int units = Integer.parseInt(commands[1]);
            switch (commands[0]) {
                case "forward" -> {
                    coordinates[0] += units;
                    coordinates[1] += units * coordinates[2];
                }
                case "down" -> coordinates[2] += units;
                case "up" -> coordinates[2] -= units;
                default -> System.out.println("Unrecognized command");
            }
        }
        return coordinates[0] * coordinates[1];
    }
}