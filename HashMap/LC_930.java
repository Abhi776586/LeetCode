package HashMap;
import java.util.HashMap;
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
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

            if(map.containsKey(prefixSum - goal)){
                count += map.get(prefixSum - goal);
            }

            map.put(prefixSum , map.getOrDefault(prefixSum , 0) + 1);
        }
        return count;
        
    }

    
    private int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;

        int left = 0, sum = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        // convert odd -> 1, even -> 0
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2;
        }

        return atMost(nums, k) - atMost(nums, k - 1);
    }
}
