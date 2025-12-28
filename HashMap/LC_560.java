package HashMap;
import java.util.HashMap;
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int prefixSum = 0;

       
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);

        for(int i = 0 ; i < n ; i++){
            prefixSum += nums[i];

            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum , map.getOrDefault(prefixSum , 0) + 1);
        }
        
      return count; 
    }
}

//PrefixSum works even then there are negative numbers in the array but sliding window won't work in that case will fail
//for negative numbers becusae the sum can decrease and we may miss some subarrays
