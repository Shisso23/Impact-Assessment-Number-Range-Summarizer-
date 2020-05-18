
package impactassessment;

import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hyacinthe
 */
public class NumberRangeImplementatonTest {
    
    public NumberRangeImplementatonTest() {
    }

    /**
     * Checks that the returned collection is sorted and contains only distinct integers.
     */
    @Test
    public void testCollect() {
        
        NumberRangeImplementaton numSummarizer= new NumberRangeImplementaton();
        
        Collection<Integer> actual = numSummarizer.collect("5,1,6,8,3");
        Collection<Integer> expected1 = new TreeSet(Arrays.asList(1,3,5,6,8));
        Collection<Integer> expected2 = new TreeSet(Arrays.asList(1,3,3,5,5,6,8));
   
        assertEquals(expected1, actual);
        assertEquals(expected2,actual);
        
    }

    /**
     * Checks that the numbers are grouped into a range if they're a sequence and not grouped otherwise.
     * 
     * Note: Do not include spaces in the expected output
     */
    @Test
    public void testSummarizeCollection() {
        
        NumberRangeImplementaton summarizer = new NumberRangeImplementaton();
        
        Collection<Integer> input1 = summarizer.collect("5,1,6,8,3");
        String actual1 = summarizer.summarizeCollection(input1);
        String expected1 ="1,3,5-6,8";
        
        NumberRangeImplementaton summarizer2 = new NumberRangeImplementaton();
        Collection<Integer> input2 = summarizer2.collect("1,3,6 ,7,8,12,13,14,15,21,22,23,24,31");
        String expected2 = "1,3,6-8,12-15,21-24,31";
        String actual2 = summarizer2.summarizeCollection(input2);
        
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
     
    }
    
}
