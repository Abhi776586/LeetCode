package BackTracking;
import java.util.ArrayList;
import java.util.List;  
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(nums , 0 , new ArrayList<>() ,  result);
        return result; 
        
    }
    private void solve(int[] nums , int index , List<Integer> curr ,  List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        // include
        curr.add(nums[index]);
        solve(nums , index + 1 , curr , result);

        curr.remove(curr.size() - 1); //backtrack
        //exclude
        solve(nums , index + 1 , curr , result );
    }
}
