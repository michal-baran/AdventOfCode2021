package com.advent.of.code.day6;

import com.advent.of.code.Utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Solution {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Logger");

        String inputData = Utils.readInput("day6\\input.txt").get(0);

        logger.log(Level.INFO, "" + new FishSchool(inputData)
                .simulateOverTime(256)
                .countFishes());
    }
}
