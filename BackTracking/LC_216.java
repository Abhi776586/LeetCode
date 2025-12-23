package BackTracking;
import java.util.ArrayList;
import java.util.List;  
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        solve(1 , 0 , n , k , new ArrayList<>() , result);
        return result;
        
    }
    private void solve(int i , int sum , int n , int k , List<Integer> curr , List<List<Integer>> result){
        if(sum == n && k == 0){
            result.add(new ArrayList<>(curr));
            return;
        }

        if(sum > n || k < 0) return;

        for(int idx = i ; idx <= 9 ; idx ++){
            curr.add(idx);
            solve(idx + 1 , sum + idx , n , k - 1 ,curr , result);
            curr.remove(curr.size() - 1);
        }
    }
}
