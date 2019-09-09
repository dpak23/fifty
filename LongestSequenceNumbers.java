package fiftyquestions;

import java.util.HashSet;
import java.util.Set;

public class LongestSequenceNumbers {

    public int longestSequenceNumbers(int [] a){
        if(a == null || a.length == 0) return 0;

        Set<Integer> values = new HashSet<>();
        int maxLength = 0;
        for(int i: a){
            values.add(a[i]);
        }

        for(int i : values){
            if(values.contains(i - 1)) continue;
            int length = 0;
            while(values.contains(i++)) length++;
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }
}
