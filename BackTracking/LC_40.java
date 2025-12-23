package BackTracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;      
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates , 0 , new ArrayList<>() , result , target);
        return result;  
    }
    private void solve(int[] candidates , int i ,  List<Integer> curr , List<List<Integer>> result , int target){
        if(target == 0){
            result.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0) return ;

        
        for(int j =  i ; j < candidates.length; j++){
            if(j > i && candidates[j] == candidates[j - 1]) continue;

             if (candidates[j] > target) break;

            curr.add(candidates[j]);
            solve(candidates , j + 1 , curr , result ,target - candidates[j]);
            curr.remove(curr.size() - 1 );
        }

    
    }
}
