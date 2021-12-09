package day3;

public class Solution {
    public static void main(String[] args) {
        DiagnosticProcessor diagnosticProcessor = new DiagnosticProcessor(Report.generate("input.txt"))
                .calculatePowerConsumption()
                .calculateLifeSupportRating();

        diagnosticProcessor.showRatings();
    }
}

