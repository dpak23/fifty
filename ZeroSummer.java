package fiftyquestions;

import java.util.Arrays;
import java.util.HashMap;

public class ZeroSummer {
    public int [] findZeroSum(int [] a){
        if(a == null || a.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i <= a.length; ++i){
            Integer oldIndex = map.get(sum);
            if(oldIndex == null && i == a.length) return null;
            if(oldIndex == null){
                map.put(sum, i);
                sum += a[i];
            } else {
                return Arrays.copyOfRange(a, oldIndex, i);
            }
        }
        return null;
    }
}