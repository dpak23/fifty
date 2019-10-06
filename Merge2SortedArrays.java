package fiftyquestions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Merge2SortedArrays {

    public static void merge2Sorted(int[] a, int [] b, int aLength, int bLength){
        int resultIndex = aLength + bLength - 1;
        int aIndex = aLength - 1;
        int bIndex = bLength - 1;
        while(aIndex >=0 && bIndex >= 0){
            if(a[aIndex] > b[bIndex]){
                a[resultIndex--] = a[aIndex--];
            } else if(a[aIndex] < b[bIndex]){
                a[resultIndex--] = b[bIndex--];
            } else {
                a[resultIndex--] = a[aIndex--];
                a[resultIndex--] = b[bIndex--];
            }
        }
        if(aIndex >= 0){
            while (aIndex >= 0){
                a[resultIndex--] = a[aIndex--];
            }
        } else if (bIndex >= 0){
            while (bIndex >= 0){
                a[resultIndex--] = b[bIndex--];
            }
        }
    }

    public static void main(String[] args) {
        int [] one = {1,3,5,7,9,0, 0 ,0};
        int [] two = {2, 4, 6};
        merge2Sorted(one, two, 5, 3);
        List<Integer> finalList = Arrays
                .stream(one).boxed().collect(Collectors.toList());
        finalList.stream().forEach(x-> System.out.println(x));
    }
}
