package TwoPointer;
import java.util.Arrays;
import java.util.HashMap;

//two pointer approach
class Solution {
    boolean twoSum(int arr[], int target) {
        Arrays.sort(arr);
        
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int sum = arr[start] + arr[end];
            if(sum == target){
                return true;
            }
            else if(sum < target){
                start++;
            }
            else{
                end--;
            }
        }
        return false;
    }
    boolean twoSumoptimized(int arr[], int target) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length; i++){
            int first = arr[i];
            int second = target - first;
            if(map.containsKey(second)){
                return true;
            }
            map.put(first , i);
        }
        return false;
    }
}

