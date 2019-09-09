package fiftyquestions;

public class TrappingRainWater {

    public int trap(int[] height) {
        int answerUnits = 0;
        int left = 0, right = height.length - 1, maxLeft = 0, maxRight = 0;
        while (left < right){
            if(height[left] < height[right]){
                if(maxLeft > height[left]){
                    answerUnits += maxLeft - height[left];
                } else {
                    maxLeft = height[left];
                }
                ++left;
            } else {
                if(maxRight > height[right]){
                    answerUnits += maxRight - height[right];
                } else {
                    maxRight = height[right];
                }
                --right;
            }
        }
        return answerUnits;
    }
}
