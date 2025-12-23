package BackTracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums , 0 , result);
        return result;
        
    }
    private void solve(int[] nums , int index , List<List<Integer>> result){
        if(index == nums.length){
            List<Integer> current = new ArrayList<>();
            for(int n :nums){
                current.add(n);
            }
            result.add(current);
            return;

        }

        Set<Integer> used = new HashSet<>();

        for(int i = index ; i < nums.length; i++){
            if(used.contains(nums[i])) continue;
            used.add(nums[i]);

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
