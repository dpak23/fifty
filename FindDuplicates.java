package fiftyquestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicates {

    public List<Integer> findDuplicates(int [] a){
        if(a==null || a.length == 0) throw new IllegalArgumentException();
        Set<Integer> resultSet = new HashSet<>();
        for(int i = 0; i < a.length; ++i){
            int index = Math.abs(a[i]) - 1;

      /* If a value is negative it means we have already seen it. If not then
      set its complement*/
            if(a[index] < 0){
                resultSet.add(Math.abs(a[i]));
            } else {
                a[index] = -a[index];
            }
        }
        //Return the array to its original form
        for(int i = 0; i < a.length; ++i){
            a[i] = Math.abs(a[i]);
        }
        return new ArrayList(resultSet);
    }
}
