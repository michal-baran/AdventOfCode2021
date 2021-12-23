package com.advent.of.code.day8;

import com.advent.of.code.Utils;

import java.util.List;
import java.util.logging.Logger;

public class Solution {
    public static final Logger logger = Logger.getLogger("Logger");

    public static void main(String[] args) {
        List<String> inputData = Utils.readInput("day8\\input.txt");
        Display display = new Display(inputData);
        logger.info(String.valueOf(display.sumEasyDigits()));
        logger.info(String.valueOf(display.sumAllOutputs()));
    }
}