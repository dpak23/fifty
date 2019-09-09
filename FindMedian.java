package fiftyquestions;

public class FindMedian {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenA = nums1.length;
        int lenB = nums2.length;
        boolean isOddLength = (lenA+lenB)%2 > 0?true:false;
        int [] small = nums1.length > nums2.length?nums2:nums1;
        int [] bigger = nums1.length > nums2.length?nums1:nums2;
        int start = 0;
        int end = small.length;
        while(start <= end){
            int partitionSmall = (start + end)/2;
            int partitionBig = ((small.length + bigger.length + 1)/2) - partitionSmall;

            int maxLeftX = partitionSmall == 0?Integer.MIN_VALUE:small[partitionSmall-1];
            int maxLeftY = partitionBig == 0?Integer.MIN_VALUE:bigger[partitionBig - 1];
            int minRightX = partitionSmall == small.length?Integer.MAX_VALUE:small[partitionSmall];
            int minRightY = partitionBig == bigger.length?Integer.MAX_VALUE:bigger[partitionBig];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if(isOddLength){
                    return Math.max(maxLeftX, maxLeftY);
                } else {
                    int maxLeft = Math.max(maxLeftX, maxLeftY);
                    int minRight = Math.min(minRightX, minRightY);
                    return (double)(maxLeft + minRight)/2;
                }
            }
            if(maxLeftX > minRightY){
                end = partitionSmall - 1;
                continue;
            }
            if(maxLeftY > minRightX){
                start = partitionSmall + 1;
                continue;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int [] num1 = {1,3,8,9,15};
        int [] num2 = {7,11,18,19,21,25};

        //int [] num1 = {23,26,31,35};
        //int [] num2 = {3,5,7,9,11,16};

        //int [] num1 = {};
        //int [] num2 = {1};
        System.out.print(findMedianSortedArrays(num1, num2));
    }
}
