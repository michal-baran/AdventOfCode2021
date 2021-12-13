package com.advent.of.code.day7;

import com.advent.of.code.Utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Solution {
    public static Logger logger = Logger.getLogger("Logger");

    public static void main(String[] args) {
        String inputData = Utils.readLine("\\day7\\input.txt");

        logger.log(Level.INFO, "" + new CrabSubmarines(inputData)
                .getOptimumFuel());
    }
}