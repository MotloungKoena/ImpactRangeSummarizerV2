package com.impact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collection;

public class NumberRangeSummarizerTest {

    @Test
    void testSummarizeCollection() {
        NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();

        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> numbers = summarizer.collect(input);
        String output = summarizer.summarizeCollection(numbers);

        assertEquals("1,3,6-8,12-15,21-24,31", output.replaceAll(" ", ""));
    }
}
