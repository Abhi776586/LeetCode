package BackTracking;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Solution {
    public List<String> powerSet(String s) {
        List<String> result = new ArrayList<>();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        s = new String(arr);
        solve(result , "" , 0 , s);
        return result;
    }
    private void solve(List<String> result , String curr , int index , String s){
        if(index == s.length()){
            result.add(curr);
            return;
        }
        // include
        solve(result , curr + s.charAt(index) , index + 1 , s);
        
        // exclude
        solve(result , curr , index + 1 , s);
    }
}
