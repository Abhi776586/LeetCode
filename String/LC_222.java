package String;
class Solution {
    public int maxDepth(String s) {
        int curr = 0;
        int max = 0;
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                curr++;
                max = Math.max(max , curr);
            }
            else if(ch == ')'){
                curr--;
            }
        }
        return max;
        
    }
}
