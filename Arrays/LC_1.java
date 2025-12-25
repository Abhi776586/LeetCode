package Arrays;
import java.util.HashMap;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0 ; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i , j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSumoptimized(int[] nums, int target) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++){
            int first = nums[i];
            int second = target - first;
            if(map.containsKey(second)){
                return new int[] {map.get(second), i};
            }
            map.put(first , i);

        }
        return new int[] {};
        
    }
}

