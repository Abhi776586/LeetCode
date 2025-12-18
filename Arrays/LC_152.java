package Arrays;
class Solution {

    // Solution 1 : Using two traversals
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        int currProd = 1;

        for(int i = 0 ; i < n; i++){
            currProd = currProd * n;
            maxProd = Math.max(currProd , maxProd);
            if(currProd == 0){
                currProd = 1;
            }
        }

        currProd = 1;
        for(int i = n - 1  ; i >= 0; i--){
            currProd = currProd * n;
            maxProd = Math.max(currProd , maxProd);
            if(currProd == 0){
                currProd = 1;
            }
        }

        return maxProd;    
    }

    // Solution 2 : Using max and min product
    public int maxProductK(int[] nums) {
        int n = nums.length;
        int maxProd = nums[0];
        int minProd = nums[0];  
        int ans = nums[0]; 

        for(int i = 1; i < n; i++){
            int num = nums[i];

            if(num < 0){
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(num , maxProd * num);
            minProd = Math.min(num , minProd * num);

            ans = Math.max(ans , maxProd);
        } 
        return ans;
    }
}

