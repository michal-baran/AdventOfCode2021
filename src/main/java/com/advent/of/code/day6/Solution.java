package com.advent.of.code.day6;

import com.advent.of.code.Utils;

public class Solution {
    public static void main(String[] args) {

        String inputData = Utils.readInput("day6\\input.txt").get(0);
        System.out.println(new FishSchool(inputData)
                .simulateOverTime(80)
                .countFishes());
    }
}
