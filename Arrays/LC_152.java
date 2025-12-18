package Arrays;
class Solution {
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
}
