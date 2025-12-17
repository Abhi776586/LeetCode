package Arrays;
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currMax = 0;
        int currMin = 0;
        int totalSum = 0;

        for(int i = 0 ; i < n ; i++){
            int num = nums[i];
            totalSum += num;

            currMax += num;
            maxSum = Math.max(currMax , maxSum);
            if(currMax< 0){
                currMax = 0;
            }

            currMin += num;
            minSum = Math.min(currMin , minSum);
            if(currMin > 0){
                currMin = 0;
            }
        }
        if(maxSum < 0) return maxSum;
        return Math.max(maxSum , totalSum - minSum);   
    }
}
