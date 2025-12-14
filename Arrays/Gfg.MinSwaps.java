package Arrays;
// User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    int minSwap(int[] arr, int k) {
        int n = arr.length;
        int good = 0;
        for(int i = 0 ; i <arr.length; i++){
            if(arr[i] <= k){
                good++;
            }
        }
        
        int bad = 0 ;
        for(int i = 0 ; i < good ; i++){
            if(arr[i] > k){
                bad++;
            }
        }
        
        int ans = bad;
        
        
        int i = 0 ,j = good;
        while(j < n){
            if(arr[i] > k) bad--;
            if(arr[j] > k) bad++;
            
            ans = Math.min(ans , bad);
            i++;
            j++;
            }
            return ans;
    }
}

