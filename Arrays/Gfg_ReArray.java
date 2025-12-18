package Arrays;
import java.util.Arrays;
class Solution {
    public void rearrange(int arr[]) {
        int n = arr.length;
        
        Arrays.sort(arr);
        long maxElem = (long)arr[n - 1] + 1;
        int maxIdx = n - 1;
        int minIdx = 0;
        for(int i = 0 ; i < n ; i++){
            if(i % 2 == 0){
                arr[i] = (int)(arr[i] + (arr[maxIdx] % maxElem) * maxElem);
                maxIdx--;
            }
            else{
                arr[i] = (int)(arr[i] + (arr[minIdx] % maxElem) * maxElem);
                minIdx++;
            }
        }
        for(int i = 0 ; i < n; i++){
            arr[i] = (int)(arr[i]/maxElem);
        }
        
        
    }
}

