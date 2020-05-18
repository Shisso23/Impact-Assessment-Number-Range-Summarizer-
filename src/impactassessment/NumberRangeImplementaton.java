package impactassessment;

import java.util.Arrays;
import java.util.Collection;
import java.util.IllegalFormatConversionException;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author Hyacinthe
 */
public class NumberRangeImplementaton implements NumberRangeSummarizer {
    
    private  int count=0;  //keeps track of how many numbers are in a sequence
    private  int max=0;    // the maximum number of a sequnce
    private  String summarizedString="";  // The final output
    private  int previous=0;   // previous number in the list
    private  int last=0; // The last number of the list
    private  int elementIndex=0;  //keeps track of the indexes of list elements
    
    @Override
    public Collection<Integer> collect(String input){
        
        List<String> stringsCollection=Arrays.asList(input.replaceAll("\\s","").split(",")); //Removes all spaces , splits the string into an Array, adds Array to the list
        TreeSet<Integer> convertedToInts = new TreeSet<>(); //Stores distinct converted string numbers into integers.
        
        //converts each character to Integer
        try{
            stringsCollection.forEach(stringNum->convertedToInts.add(Integer.parseInt(stringNum)));
                
        }catch(IllegalFormatConversionException e){
            System.out.println("Wrong input entered!");
        }
            
        return convertedToInts;
    }
    
    @Override
    public String summarizeCollection(Collection<Integer> input){
        
        previous=input.stream().findFirst().get();  //gets the first element of the Collection
        
        input.forEach((current)->{switch (current-previous) {
                case 1:
                    count++;// count keeps track of how many numbers are in a sequence
                    max=current; // max is the maximum number in this sequence
                    previous=current;
                    elementIndex++;  //keeps track on the current index(not counting 0)
                    if(elementIndex == input.size())summarizedString+="-"+current; //add the last element
                    break;
                case 0:
                    elementIndex++;
                    summarizedString+=current;
                    break;
                    
                default:
                    if(count>0){
                        summarizedString+="-"+max;
                        summarizedString+=","+current;
                        previous=current;
                        count=0;
                        elementIndex++;               
                    }
                    else{
                        summarizedString+=","+current;
                        previous=current;
                        elementIndex++;
                    }       break;
            }
        });
        
        return summarizedString;
    }
}
