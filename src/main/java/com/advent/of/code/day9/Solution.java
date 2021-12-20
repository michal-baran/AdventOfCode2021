package com.advent.of.code.day9;

import com.advent.of.code.Utils;

import java.util.List;
import java.util.logging.Logger;

public class Solution {

    public static Logger logger = Logger.getLogger("logger");

    public static void main(String[] args) {
        List<String> inputData = Utils.readInput("day9\\input.txt");
        Cave cave = new Cave(inputData);

        logger.info(cave.findLocations().getRiskLevelsSum().toString());
    }
}
