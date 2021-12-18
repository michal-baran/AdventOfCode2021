package com.advent.of.code.day8;

import java.util.ArrayList;
import java.util.List;

public class Display {
    private List<OutputEntry> outputEntries = new ArrayList<>();

    public Display(List<String> input) {
        for (String s : input) {
            outputEntries.add(new OutputEntry(s));
        }
    }

    public long sumAllOutputs() {
        long result = 0;
        for (OutputEntry outputEntry : outputEntries) {
            result += outputEntry.getOutputValue();
        }
        return result;
    }

    public long sumEasyDigits() {
        long result = 0;
        for (OutputEntry outputEntry : outputEntries) {
            result += outputEntry.getEasyDigitsCount();
        }
        return result;
    }
}