package com.advent.of.code.day4;

import com.advent.of.code.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        final List<String> inputData = Utils.readInput("day4\\input.txt");
        final List<Integer> numbers = getNumbers(inputData.get(0));
        final List<Board> boards = getBoards(inputData);

        Game game = new Game();
        game.play(numbers, boards);
        game.fail(numbers, boards);
    }

    private static List<Board> getBoards(List<String> inputData) {
        inputData.remove(0);
        inputData.remove(0);

        List<Board> boards = new ArrayList<>();
        List<List<Field>> fields = new ArrayList<>();

        for (String row : inputData) {
            if (row.isEmpty()) {
                boards.add(new Board(fields));
                fields = new ArrayList<>();
            } else {
                fields.add(Stream.of(row.trim().split("\\s+"))
                        .map(item -> new Field(Integer.parseInt(item)))
                        .collect(Collectors.toList()));
            }
        }
        boards.add(new Board(fields));
        return boards;
    }

    private static List<Integer> getNumbers(String numbers) {
        return Stream.of(numbers.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
