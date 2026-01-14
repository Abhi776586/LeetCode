package Tree;
class Solution {
    static int MOD = 1_000_000_007;
    long[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        
        //pascal triangle
        comb = new long[n + 1][n + 1];
        for(int i = 0; i <= n; i++){
            comb[i][0] = comb[i][i] = 1;
            for(int j = 1; j < i; j++){
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }
        
        long ans = dfs(nums);
        return (int)((ans - 1 + MOD) % MOD);
        
    }
    private long dfs(int[] nums){
        int n = nums.length;

        if(n <= 2){
            return 1;
        }
        int root = nums[0];
        
        //count which is less than root
        int leftSize = 0;
        for(int i = 1 ; i < n ; i++){
            if(nums[i] < root){
                leftSize++;
            }
        }

        //count which is greater than root
        int rightSize = n - 1 - leftSize;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        
        //compute to go left or right
        int l = 0 , r = 0;
        for(int i = 1 ; i < n ; i++){
            if(nums[i] < root){
                left[l++] = nums[i];
            }
            else{
                right[r++] = nums[i];
            }
        }
        //call left and right
        long leftWays = dfs(left);
        long rightWays = dfs(right);

        long ways = comb[leftSize + rightSize][leftSize];
        ways = (ways * leftWays) % MOD;
        ways = (ways * rightWays) % MOD;

        return ways;


    }
}
