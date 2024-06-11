import java.util.*;

import numberrangesummarizer.RangeSummarizer;

/**
 * Main class to demonstrate the functionality of RangeSummarizer.
 * 
 * @author Thabang
 */
public class Main {
    public static void main(String args[]){
        RangeSummarizer summarizer = new RangeSummarizer();

        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

        Collection<Integer> collectedInput = summarizer.collect(input);
        String summarized = summarizer.summarizeCollection(collectedInput);
        
        System.out.println(summarized); // Output: "1, 3, 6-8, 12-15, 20, 22-24, 31"
    }
}
