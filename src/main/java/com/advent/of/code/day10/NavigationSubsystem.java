package com.advent.of.code.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class NavigationSubsystem {
    private String[] brackets = {"([{<", ")]}>"};
    private List<String> lines;
    public List<List<Character>> completionSequences = new ArrayList<>();

    public NavigationSubsystem(List<String> lines) {
        this.lines = lines;
    }

    public void checkSyntaxError() {
        int result = 0;
        for (String line : lines) {
            result += inspectLine(line);
        }
        Solution.logger.info("Total syntax error is " + result);
    }

    public void getMiddleScore() {
        long[] scores = new long[completionSequences.size()];
        Map<Character, Integer> points = Map.of(
                ')', 1,
                ']', 2,
                '}', 3,
                '>', 4);
        for (int i = 0; i < completionSequences.size(); i++) {
            long result = 0;
            for (int j = completionSequences.get(i).size() - 1; j >= 0; j--) {
                List<Character> bracket = completionSequences.get(i);
                result = result * 5 + points.get(bracket.get(j));
            }
            scores[i] = result;
        }
        Arrays.sort(scores);
        Solution.logger.info("Middle score equals " + scores[scores.length / 2]);
    }

    private int inspectLine(String line) {
        Map<Character, Integer> points = Map.of(
                ')', 3,
                ']', 57,
                '}', 1197,
                '>', 25137);

        List<Character> inspectList = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            char charOfLine = line.charAt(i);
            int index = brackets[0].indexOf(charOfLine);

            if (index > -1) {
                inspectList.add(brackets[1].charAt(index));
            } else {
                int lastIndex = inspectList.size() - 1;
                char found = brackets[1].charAt(brackets[1].indexOf(charOfLine));
                char expected = inspectList.get(lastIndex);

                if (found == expected) {
                    inspectList.remove(lastIndex);
                } else {
                    return points.get(found);
                }
            }
        }
        completionSequences.add(inspectList);
        return 0;
    }
}