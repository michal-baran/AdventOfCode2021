package day3;

import java.util.ArrayList;
import java.util.List;

public class DiagnosticProcessor {
    private final List<String> report;
    private int powerConsumption;
    private int lifeSupportRating;

    public DiagnosticProcessor(List<String> report) {
        this.report = report;
    }

    public void showRatings() {
        System.out.println("Power consumption = " + powerConsumption);
        System.out.println("Life support rating = " + lifeSupportRating);
    }

    public DiagnosticProcessor calculatePowerConsumption() {
        int gammaRate = binaryToInt(calcRate('1'));
        int epsilonRate = binaryToInt(calcRate('0'));
        this.powerConsumption = gammaRate * epsilonRate;
        return this;
    }

    public DiagnosticProcessor calculateLifeSupportRating() {
        int oxygenRate = binaryToInt(filterValues(report, true));
        int co2Rate = binaryToInt(filterValues(report, false));
        this.lifeSupportRating = oxygenRate * co2Rate;
        return this;
    }

    private int[] calcRate(char bitChar) {
        int rowLength = report.get(0).length();
        int[] numOfBits = new int[rowLength];

        for (String s : report) {
            for (int i = 0; i < rowLength; i++) {
                numOfBits[i] += (s.charAt(i) == bitChar ? 1 : 0);
            }
        }
        return numOfBits;
    }

    private int binaryToInt(int[] binaryList) {
        int intValue = 0;
        for (int i = 0; i < binaryList.length; i++) {
            if (binaryList[i] > report.size() - binaryList[i]) {
                intValue += binaryValue(binaryList.length - 1 - i);
            }
        }
        return intValue;
    }

    private int binaryToInt(List<String> binaryValue) {
        int intValue = 0;
        String stringValue = binaryValue.get(0);

        for (int i = 0; i < stringValue.length(); i++) {
            if (stringValue.charAt(i) == '1') {
                intValue += binaryValue(stringValue.length() - 1 - i);
            }
        }
        return intValue;
    }

    private double binaryValue(int index) {
        return Math.pow(2, index);
    }

    private List<String> filterValues(List<String> inputList, boolean oxygenMode) {
        return filterValues(inputList, oxygenMode, 0);
    }

    private List<String> filterValues(List<String> inputList, boolean oxygenMode, int index) {
        int numOfOnes = 0;
        int numOfZeros = 0;

        for (String s : inputList) {
            if (s.charAt(index) == '1') {
                numOfOnes++;
            } else {
                numOfZeros++;
            }
        }
        char charToCheck;
        if (oxygenMode) {
            charToCheck = (numOfOnes >= numOfZeros ? '1' : '0');
        } else {
            charToCheck = (numOfOnes < numOfZeros ? '1' : '0');
        }
        List<String> filteredNumbers = new ArrayList<>();

        for (String s : inputList) {
            if (s.charAt(index) == charToCheck) {
                filteredNumbers.add(s);
            }
        }
        if (filteredNumbers.size() > 1) {
            return filterValues(filteredNumbers, oxygenMode, index + 1);
        } else {
            return filteredNumbers;
        }
    }
}
