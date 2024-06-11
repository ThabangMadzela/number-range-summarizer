package tests;

// Importing necessary JUnit classes
import org.junit.Test;
import static org.junit.Assert.*;

import numberrangesummarizer.NumberRangeSummarizer;
import numberrangesummarizer.RangeSummarizer;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Unit tests for the RangeSummarizer class.
 * 
 * @author Thabang
 * 
 *   Assumptions
 *      1. The input list is sorted.
 *      2. Duplicates in the input list are handled correctly.
 *      3. The input list contains integers only.
 *      4. Empty strings or null inputs are considered as empty lists.
 * 
 */
public class RangeSummarizerTest {

    private final NumberRangeSummarizer summarizer = new RangeSummarizer();

    /**
     * Tests collecting basic input.
     */
    @Test
    public void testCollectBasicInput() {
        String input = "1,3,5,7";
        Collection<Integer> expected = List.of(1, 3, 5, 7);
        assertCollect(input, expected);
    }

    /**
     * Tests collecting consecutive numbers.
     */
    @Test
    public void testCollectConsecutiveNumbers() {
        String input = "1,2,3,4";
        Collection<Integer> expected = List.of(1, 2, 3, 4);
        assertCollect(input, expected);
    }

    /**
     * Tests collecting mixed input with consecutive and non-consecutive numbers.
     */
    @Test
    public void testCollectMixedInput() {
        String input = "1,2,3,5,6,8,9,10";
        Collection<Integer> expected = List.of(1, 2, 3, 5, 6, 8, 9, 10);
        assertCollect(input, expected);
    }

    /**
     * Tests collecting a single element.
     */
    @Test
    public void testCollectSingleElement() {
        String input = "5";
        Collection<Integer> expected = List.of(5);
        assertCollect(input, expected);
    }

    /**
     * Tests collecting from an empty input string.
     */
    @Test
    public void testCollectEmptyInput() {
        String input = "";
        Collection<Integer> expected = Collections.emptyList();
        assertCollect(input, expected);
    }

    /**
     * Tests collecting duplicate numbers.
     */
    @Test
    public void testCollectDuplicateNumbers() {
        String input = "1,1,2,2,3,3";
        Collection<Integer> expected = List.of(1, 1, 2, 2, 3, 3);
        assertCollect(input, expected);
    }

    /**
     * Tests collecting unsorted input.
     */
    @Test
    public void testCollectUnsortedInput() {
        String input = "3,1,2";
        Collection<Integer> expected = List.of(3, 1, 2);
        assertCollect(input, expected);
    }

    /**
     * Tests collecting negative numbers.
     */
    @Test
    public void testCollectNegativeNumbers() {
        String input = "-3,-2,-1,0,1,2,3";
        Collection<Integer> expected = List.of(-3, -2, -1, 0, 1, 2, 3);
        assertCollect(input, expected);
    }

    /**
     * Tests collecting numbers at the boundary of integer limits.
     */
    @Test
    public void testCollectBoundaryConditions() {
        String input = "2147483645,2147483646,2147483647";
        Collection<Integer> expected = List.of(2147483645, 2147483646, 2147483647);
        assertCollect(input, expected);
    }

    /**
     * Tests summarizing basic input.
     */
    @Test
    public void testSummarizeBasicInput() {
        Collection<Integer> input = List.of(1, 3, 5, 7);
        String expected = "1, 3, 5, 7";
        assertSummarize(input, expected);
    }

    /**
     * Tests summarizing consecutive numbers.
     */
    @Test
    public void testSummarizeConsecutiveNumbers() {
        Collection<Integer> input = List.of(1, 2, 3, 4);
        String expected = "1-4";
        assertSummarize(input, expected);
    }

    /**
     * Tests summarizing mixed input with consecutive and non-consecutive numbers.
     */
    @Test
    public void testSummarizeMixedInput() {
        Collection<Integer> input = List.of(1, 2, 3, 5, 6, 8, 9, 10);
        String expected = "1-3, 5-6, 8-10";
        assertSummarize(input, expected);
    }

    /**
     * Tests summarizing a single element.
     */
    @Test
    public void testSummarizeSingleElement() {
        Collection<Integer> input = List.of(5);
        String expected = "5";
        assertSummarize(input, expected);
    }

    /**
     * Tests summarizing an empty collection.
     */
    @Test
    public void testSummarizeEmptyInput() {
        Collection<Integer> input = Collections.emptyList();
        String expected = "";
        assertSummarize(input, expected);
    }

    /**
     * Tests summarizing duplicate numbers.
     */
    @Test
    public void testSummarizeDuplicateNumbers() {
        Collection<Integer> input = List.of(1, 1, 2, 2, 3, 3);
        String expected = "1-3";
        assertSummarize(input, expected);
    }

    /**
     * Tests summarizing unsorted input.
     */
    @Test
    public void testSummarizeUnsortedInput() {
        Collection<Integer> input = List.of(3, 1, 2);
        String expected = "1-3";
        assertSummarize(input, expected);
    }

    /**
     * Tests summarizing negative numbers.
     */
    @Test
    public void testSummarizeNegativeNumbers() {
        Collection<Integer> input = List.of(-3, -2, -1, 0, 1, 2, 3);
        String expected = "-3-3";
        assertSummarize(input, expected);
    }

    /**
     * Tests summarizing numbers at the boundary of integer limits.
     */
    @Test
    public void testSummarizeBoundaryConditions() {
        Collection<Integer> input = List.of(2147483645, 2147483646, 2147483647);
        String expected = "2147483645-2147483647";
        assertSummarize(input, expected);
    }

    /**
     * Helper method to assert the collect method's functionality.
     * 
     * @param input the input string of numbers
     * @param expected the expected collection of integers
     */
    private void assertCollect(String input, Collection<Integer> expected) {
        Collection<Integer> collected = summarizer.collect(input);
        assertEquals(expected, collected);
    }

    /**
     * Helper method to assert the summarize method's functionality.
     * 
     * @param input the input collection of integers
     * @param expected the expected summary string
     */
    private void assertSummarize(Collection<Integer> input, String expected) {
        String summarized = summarizer.summarizeCollection(input);
        assertEquals(expected, summarized);
    }
}
