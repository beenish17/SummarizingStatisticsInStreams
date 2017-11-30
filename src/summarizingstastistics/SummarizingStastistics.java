
package summarizingstastistics;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SummarizingStastistics {

    public static void main(String[] args) {
     //List bunny= Arrays.asList(2,22,1,0,4,77,21,88,9,3); bunny can be converted to stream but canot be converted to INtStream.
       IntStream bunn=IntStream.of(2,22,1,4,77,21,88,9,3);
     //IntStream bunn1=IntStream.of(); it will throw Runtime Exception.
       System.out.println(max(bunn)); //finds max in the list.
       System.out.println("---Summarizing Statstics---");
       // we cant use two terminal operations for one stream so summarizing statistics do this for us. min() and max() are both terminal operations.
       IntStream bunn2=IntStream.of(2,22,1,4,77,21,88,9,3);
       System.out.println(range(bunn2));
       
    }
    private static int max(IntStream ints){
        OptionalInt optional =ints.max();
        return optional.orElseThrow(RuntimeException:: new);
    }
    private static int range(IntStream ints){
        IntSummaryStatistics stats=ints.summaryStatistics();
        if(stats.getCount()==0)
            throw new RuntimeException();
            
        return stats.getMax()-stats.getMin();
    }
}
