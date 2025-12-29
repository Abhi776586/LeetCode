package BackTracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;      
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums , 0 , new ArrayList<>() , result);
        return result; 
        
    }
    private void solve(int[] nums , int index , List<Integer> curr , List<List<Integer>> result){

        if(index == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        solve(nums , index + 1 , curr , result);

        curr.remove(curr.size() - 1);

        int i = index + 1;
        while(i < nums.length && nums[i] == nums[i - 1]){
            i++;
        }
        solve(nums , i , curr , result);
    }
}
