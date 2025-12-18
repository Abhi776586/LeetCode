package Arrays;
class Solution{
    public int validParentheses(int n){
       if(n % 2 != 0) return 0;

       int pairs = n / 2;
       int[] dp = new int[pairs + 1];

       dp[0] = 1;
       dp[1] = 1;
       for(int i  =2 ; i <= pairs; i++){
         dp[i] = 0;
         for(int j = 0 ; j < i ; j++){
            dp[i] += dp[j] * dp[i - j - 1];
         }
       }
       return dp[pairs];
    }
}