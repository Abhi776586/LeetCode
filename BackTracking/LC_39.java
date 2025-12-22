package BackTracking;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        solve(candidates , 0 , new ArrayList<>() , result , target);
        return result;     
    }
    private void solve(int[] candidates , int i , List<Integer> curr , List<List<Integer>> result , int target){
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0) return ;

        for(int idx = i ; idx < candidates.length; idx++){
            curr.add(candidates[idx]);
            solve(candidates , idx, curr , result ,target - candidates[idx]);
            curr.remove(curr.size() - 1);
        }
    }
}
