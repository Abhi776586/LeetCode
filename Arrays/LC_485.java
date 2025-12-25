package Arrays;
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        for(int i  = 0 ; i < n; i++ ){
            if(nums[i] == 0){
                sum = 0;
            }
            else{
                sum += nums[i];
                ans = Math.max(ans , sum);
            }
        }
        return ans;
        
    }
}
