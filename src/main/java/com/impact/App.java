package com.impact;

import java.util.Collection;

public class App {
    public static void main(String[] args) {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();

        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> numbers = summarizer.collect(input);
        String output = summarizer.summarizeCollection(numbers);

        System.out.println("Input:  " + input);
        System.out.println("Output: " + output);
    }
}
