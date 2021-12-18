package com.advent.of.code.day8;

import java.util.*;

public class OutputEntry {
    private String[] values;
    private String[] signalPatterns;
    private Map<Integer, String> decryptedPatterns = new HashMap<>();
    private int outputValue = 0;
    private int easyDigitsCount = 0;

    public OutputEntry(String input) {
        String[] temp = input.split("\\|");
        this.signalPatterns = temp[0].trim().split(" ");
        this.values = temp[1].trim().split(" ");

        setEasyDigits();
        setHardDigits();
        decryptOutputs();
    }

    private void setEasyDigits() {
        for (String pattern : signalPatterns) {
            int length = pattern.length();
            switch (length) {
                case 2 -> decryptedPatterns.put(1, pattern);
                case 3 -> decryptedPatterns.put(7, pattern);
                case 4 -> decryptedPatterns.put(4, pattern);
                case 7 -> decryptedPatterns.put(8, pattern);
            }
        }
    }

    private void setHardDigits() {
        int length;
        for (String pattern : signalPatterns) {
            length = pattern.length();

            if (length == 5) {
                if (match(pattern, subString(decryptedPatterns.get(4), decryptedPatterns.get(1)))) {
                    decryptedPatterns.put(5, pattern);
                } else if (match(pattern, decryptedPatterns.get(1))) {
                    decryptedPatterns.put(3, pattern);
                } else {
                    decryptedPatterns.put(2, pattern);
                }
            }
        }

        for (String pattern : signalPatterns) {
            length = pattern.length();

            if (length == 6) {
                if (!match(pattern, decryptedPatterns.get(5))) {
                    decryptedPatterns.put(0, pattern);
                } else if (match(pattern, decryptedPatterns.get(1))) {
                    decryptedPatterns.put(9, pattern);
                } else {
                    decryptedPatterns.put(6, pattern);
                }
            }
        }
    }

    private boolean match(String pattern1, String pattern2) {
        for (Character c : pattern2.toCharArray()) {
            if (!pattern1.contains(c.toString())) {
                return false;
            }
        }
        return true;
    }

    private String subString(String first, String second) {
        String result = first;
        char[] arr = second.toCharArray();
        for (Character c : arr) {
            result = result.replace(c.toString(), "");
        }
        return result;
    }

    private void decryptOutputs() {
        StringBuilder result = new StringBuilder();
        for (String output : values) {
            for (Map.Entry<Integer, String> entry : decryptedPatterns.entrySet()) {
                Integer key = entry.getKey();
                String value = entry.getValue();
                if (output.length() == value.length() && match(output, value)) {
                    result.append(key.toString());
                    if (key == 1 || key == 4 || key == 7 || key == 8) {
                        easyDigitsCount++;
                    }
                }
            }
        }
        outputValue = Integer.parseInt(result.toString());
    }

    public int getOutputValue() {
        return outputValue;
    }

    public int getEasyDigitsCount() {
        return easyDigitsCount;
    }
}