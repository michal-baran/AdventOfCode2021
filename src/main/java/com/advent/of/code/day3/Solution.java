package com.advent.of.code.day3;

public class Solution {
    public static void main(String[] args) {
        DiagnosticProcessor diagnosticProcessor = new DiagnosticProcessor(Report.generate("day6/input.txt"))
                .calculatePowerConsumption()
                .calculateLifeSupportRating();

        diagnosticProcessor.showRatings();
    }
}

