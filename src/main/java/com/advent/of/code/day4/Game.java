package com.advent.of.code.day4;

import java.util.List;

public class Game {
    public int play(List<Integer> numbers, List<Board> boards) {
        for (Integer number : numbers) {
            for (Board board : boards) {
                board.markNumber(number);
                if (board.doesWin()) {
                    System.out.println(board.calculateResult(number));
                    return board.calculateResult(number);
                }
            }
        }
        throw new UnsupportedOperationException("No winning board");
    }

    public int fail(List<Integer> numbers, List<Board> boards) {
        int lastWinResult = 0;
        for (Integer number : numbers) {
            for (Board board : boards) {
                board.markNumber(number);
                if (board.doesWin()) {
                    System.out.println(board.calculateResult(number));
                    lastWinResult = board.calculateResult(number);
                }
            }
        }
        return lastWinResult;
    }
}