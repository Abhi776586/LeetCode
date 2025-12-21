package Recursions;
class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1; 
        return fib(n - 1) + fib(n - 2);
       
    }


    //Iterative Approach
    // TC - O(n)
    // SC - O(1)


    public int fibIterative(int n) {
        if(n <= 1) return n;

       int a = 0 , b = 1;
       for(int i = 2 ; i <= n ; i++){
        int c = a + b;
        a = b;
        b = c;
       }
       return b;
    }

    //Memoization(Top-Down DP)
    // TC - O(n)
    // SC - O(n)

    int[] memo = new int[31];
    public int fibMemo(int n) {
        if (n <= 1) return n;

        if (memo[n] != 0) return memo[n];

        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }


    //Bottom-Up Tabulation
    // TC - O(n)
    // SC - O(n)
    
    public int fibonacci(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}





// Recusive Approach
// TC - O(2^n)
// SC - O(n)





