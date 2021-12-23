package com.advent.of.code.day10;

import com.advent.of.code.Utils;

import java.util.List;
import java.util.logging.Logger;

public class Solution {
    public static Logger logger = Logger.getLogger("logger");

    public static void main(String[] args) {
        List<String> inputData = Utils.readInput("day10\\input.txt");

        NavigationSubsystem navigationSubsystem = new NavigationSubsystem(inputData);
        navigationSubsystem.checkSyntaxError();
        navigationSubsystem.getMiddleScore();
    }
}
