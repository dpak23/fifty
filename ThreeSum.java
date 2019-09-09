package fiftyquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0) return results;

        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 3; ++i) {
            if(i == 0 || nums[i] > nums[i - 1]){
                int start = i + 1;
                int end = nums.length - 1;
                while(start < end){
                    if(nums[i] + nums[start] + nums[end] == 0){
                        List<Integer> resultListItem = new ArrayList<>();
                        resultListItem.add(nums[i]);
                        resultListItem.add(nums[start]);
                        resultListItem.add(nums[end]);
                        results.add(resultListItem);
                    }
                    if(nums[i] + nums[start] + nums[end] < 0){
                        int currentStart = start;
                        while(nums[start]==nums[currentStart] && start < end){
                            start++;
                        }
                    } else {
                        int currentEnd = end;
                        while(nums[end]==nums[currentEnd] && start < end){
                            end--;
                        }
                    }
                }
            }
        }
        return results;
    }
}
