package day2;

import java.util.List;

public class Submarine {
    public static void main(String[] args) {
        List<String> course = Commands.generate("input.txt");
        System.out.println(calculatePosition(course));
    }

    public static int calculatePosition(List<String> course) {
        int[] coordinates = new int[2];
        for (String s : course) {
            String[] commands = s.split(" ");
            switch (commands[0]) {
                case "forward" -> coordinates[0] += Integer.parseInt(commands[1]);
                case "down" -> coordinates[1] += Integer.parseInt(commands[1]);
                case "up" -> coordinates[1] -= Integer.parseInt(commands[1]);
                default -> System.out.println("Unrecognized command");
            }
        }
        return coordinates[0] * coordinates[1];
    }
}