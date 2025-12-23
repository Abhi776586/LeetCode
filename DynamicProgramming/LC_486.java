package DynamicProgramming;
class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];


        for(int i = 0 ; i < n ; i++){ //base case
            dp[i][i] = nums[i];
        }

        for(int diff = 1 ; diff < n ; diff++){
            for(int left = 0 ;left + diff < n; left++){
                int right = diff + left;

                int takeLeft = nums[left] - dp[left + 1][right];
                int takeRight = nums[right] - dp[left][right - 1];

                dp[left][right] = Math.max(takeLeft , takeRight);
            }
        }
        return dp[0][n - 1] >= 0;
        
    }
}
