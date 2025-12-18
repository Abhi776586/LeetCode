package Arrays;
import java.util.Arrays;

class Solution {
    boolean findSwapValues(int[] a, int[] b) {
        int sumA = 0;
        int sumB = 0;
        
        for(int i = 0 ; i < a.length; i++){
            sumA += a[i];
        }
        
        for(int i = 0 ; i < b.length; i++){
            sumB += b[i];
        }
        
        
        int diff = sumA - sumB;
        if(diff % 2 != 0){
            return false;
        }
        
        Arrays.sort(b);
        int target = diff/2;
        for(int i = 0 ; i < a.length ; i++){
            int req = a[i] - target;
            if(Arrays.binarySearch(b , req) >= 0){
                return true;
            }
        }
        return false;
        
    }
}

