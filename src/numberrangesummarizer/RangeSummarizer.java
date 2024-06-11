package numberrangesummarizer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Thabang
 * 
 * Implementation of the NumberRangeSummarizer interface.
 * Converts a comma-separated string of numbers into a collection of integers
 * and summarizes the collection by grouping consecutive numbers into ranges.
 * 
 */
public class RangeSummarizer implements NumberRangeSummarizer{
    
    /**
     * Collects the input string and converts it to a collection of integers.
     * 
     * @param input a comma-separated string of numbers
     * @return a collection of integers
     * 
     */
    @Override
    public Collection<Integer> collect(String input){

        // Handle empty or null input
        if (input == null || input.trim().isEmpty()) {
            return Collections.emptyList();
        }
 
        // Split the input string by commas, 
        // parse each part into an integer, and collect them into a list.
        return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
    }


    /**
     * Summarizes the collection of integers by grouping consecutive numbers into ranges.
     * 
     * @param input a collection of integers
     * @return a string summarizing the collection
     * 
     */
    @Override
    public String summarizeCollection(Collection<Integer> input){
        // Handle empty input collection
        if (input.isEmpty()){
            return "";   
        }

        // Remove duplicates and sort the collection
        List<Integer> inputAsArrLst = input.stream().distinct()
                                        .sorted().collect(Collectors.toList());


        StringBuilder result = new StringBuilder();
        int rangeStrt = inputAsArrLst.get(0);
        int prevNum = inputAsArrLst.get(0);

        // Iterate through the sorted list to find ranges
        for(int i = 1; i < inputAsArrLst.size(); i++){
            int currentNum = inputAsArrLst.get(i);

            // If current number is not consecutive, append the previous range
            if (currentNum != (prevNum+1)){
                appendRange(result, rangeStrt, prevNum);
                rangeStrt = currentNum;
            }
            
            prevNum = currentNum;
        }
        // Append the last range
        appendRange(result, rangeStrt, prevNum);

        return result.toString();
    }

    /**
     * Helper method to append a range to the result.
     * 
     * @param result the StringBuilder to append the range to
     * @param start the start of the range
     * @param end the end of the range
     * 
     */
    private void appendRange(StringBuilder result, int start, int end){
        if (result.length() > 0){
            result.append(", ");
        }
        if (start == end){
            result.append(start);
        } else {
            result.append(start).append("-").append(end);
        }
    }

}
