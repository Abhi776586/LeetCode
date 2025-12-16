package Searching;
import java.util.ArrayList;
class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> duplicates = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            int val = Math.abs(arr[i]);
            int idx = val - 1;
            if(arr[idx] < 0){
                duplicates.add(val);
            }
            else{
                arr[idx] = -arr[idx];
            }
        }
        return duplicates;
    }
}
