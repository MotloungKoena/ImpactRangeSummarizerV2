package com.impact;

import java.util.*;
import java.util.stream.Collectors;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input.isEmpty()) return "";

        List<Integer> numbers = new ArrayList<>(input);
        StringBuilder result = new StringBuilder();

        int start = numbers.get(0);
        int prev = start;

        for (int i = 1; i < numbers.size(); i++) {
            int current = numbers.get(i);
            if (current != prev + 1) {
                appendRange(result, start, prev);
                start = current;
            }
            prev = current;
        }

        appendRange(result, start, prev);
        return result.toString();
    }

    private void appendRange(StringBuilder sb, int start, int end) {
        if (sb.length() > 0) sb.append(", ");
        if (start == end) sb.append(start);
        else sb.append(start).append("-").append(end);
    }
}
