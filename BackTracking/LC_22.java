package BackTracking;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve(result , "" , n , n);
        return result;
    }
        private void solve(List<String> result , String curr , int open , int close){
            if(open == 0 && close == 0){
                result.add(curr);
                return;
            }
            if(open != 0){
                solve(result , curr + "(" , open - 1 , close);       
            }
            if(close > open){
               solve(result , curr + ")" , open , close - 1);
            }
        }   
    }