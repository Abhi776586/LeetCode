package SlidingWindow;
import java.util.HashMap;
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int prefixSum = 0;

        for(int i = 0 ; i < n ; i++){
            nums[i] = nums[i] % 2;
        }
        
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);

        for(int i = 0 ; i < n; i++){
            prefixSum += nums[i];

            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum , map.getOrDefault(prefixSum , 0) + 1);
        }
        return count;
    
    }
}
