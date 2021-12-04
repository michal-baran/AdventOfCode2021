package day3;

import java.util.List;

public class DiagnosticProcessor {
    public static void main(String[] args) {
        List<String> report = Report.generate("input.txt");
        System.out.println(new DiagnosticProcessor().calculatePowerConsupmtion(report));
    }

    public int calculatePowerConsupmtion(List<String> report) {
        int rowLength = report.get(0).length();
        int[] numOfOnes = new int[rowLength];
        int gammaRate = 0;
        int epsilonRate = 0;

        //Sum every "ones" on each bit
        for (String s : report) {
            for (int i = 0; i < rowLength; i++) {
                numOfOnes[i] += (s.charAt(i) == '1' ? 1 : 0);
            }
        }

        for (int i = 0; i < rowLength; i++) {
            double valueOnBit = Math.pow(2, rowLength - 1 - i);
            int numOfZeros = report.size() - numOfOnes[i];
            if (numOfOnes[i] > numOfZeros) {
                gammaRate += valueOnBit;
            } else {
                epsilonRate += valueOnBit;
            }
        }
        return gammaRate * epsilonRate;
    }
}