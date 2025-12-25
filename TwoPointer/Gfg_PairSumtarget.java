package TwoPointer;
import java.util.Arrays;
// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        Arrays.sort(arr);
        int start = 0 ;
        int end = arr.length - 1;
        int count = 0;
        
        while(start < end){
            int sum = arr[start] + arr[end];
            if(sum < target){
                start++;
            }
            else if(sum > target){
                end--;
            }
            else{
                if(arr[start] == arr[end]){
                    int n = end - start + 1;
                    count += n * (n - 1)/2;
                    break;
                }
                int leftval = arr[start];
                int rightval = arr[end];
                int leftcount = 0;
                int rightcount = 0;
                
                while(start < end && arr[start] == leftval){
                    leftcount++;
                    start++;
                }
                while(start <= end && arr[end] == rightval){
                    rightcount++;
                    end--;
                }
                count += leftcount * rightcount;
            }
        }
        return count;
    }
}
