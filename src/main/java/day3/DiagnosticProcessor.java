package day3;

import java.util.List;

public class DiagnosticProcessor {
    public static void main(String[] args) {
        List<String> report = Report.generate("input.txt");
        System.out.println(new DiagnosticProcessor().calculatePowerConsupmtion(report));
    }

    public int calculatePowerConsupmtion(List<String> report) {
        int gammaRate = binaryToInt(calculateRate(report, '1'), report.size());
        int epsilonRate = binaryToInt(calculateRate(report, '0'), report.size());
        return gammaRate * epsilonRate;
    }

    public static int[] calculateRate(List<String> report, char bitChar) {
        int rowLength = report.get(0).length();
        int[] numOfBits = new int[rowLength];

        for (String s : report) {
            for (int i = 0; i < rowLength; i++) {
                numOfBits[i] += (s.charAt(i) == bitChar ? 1 : 0);
            }
        }
        return numOfBits;
    }

    public static int binaryToInt(int[] binaryValue, int reportSize) {
        int intValue = 0;
        for (int i = 0; i < binaryValue.length; i++) {
            double valueOnBit = Math.pow(2, binaryValue.length - 1 - i);
            if (binaryValue[i] > reportSize - binaryValue[i]) {
                intValue += valueOnBit;
            }
        }
        return intValue;
    }


}
