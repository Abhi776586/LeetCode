package BackTracking;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(nums , 0 , result);
        return result;  
    }
    private void solve(int[] nums , int index , List<List<Integer>> result){
        if(index == nums.length){
            List<Integer> current = new ArrayList<>();
            for(int n : nums){
                current.add(n);
            }
            result.add(current);
            return;
        }
        for(int i = index ; i < nums.length; i++){
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            solve(nums , index + 1 , result);
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }

    }
}
