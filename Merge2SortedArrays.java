package fiftyquestions;

public class Merge2SortedArrays {

    public void merge2Sorted(int[] a, int [] b, int aLength, int bLength){
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
}
