package DynamicProgramming;
// User function Template for Java

class Solution {
    static int count(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 1;
    
    
    for(int n = 2 ; n <= N ; n += 2){
        for(int i = 0 ; i <= n - 2; i += 2){
            dp[n] += dp[i] * dp[n - 2 - i];
        }
    }
    return dp[N];
        
    }

// Optimized Approach Using Catalan Number
    static int countCatalan(int N) {

        int k = N / 2;
        long res = 1;

        for (int i = 0; i < k; i++) {
            res = res * 2 * (2 * i + 1) / (i + 2);
        }

        return (int) res;
    }
}

