package Stack;
import java.util.Stack;
class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] lastidx = new int[26];
        for(int i = 0; i < n; i++){
            lastidx[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> st = new Stack<>();
        boolean[] seen = new boolean[26];

        

        for(int i = 0 ; i < n; i++){
            char ch = s.charAt(i);
            int curr = ch - 'a';

            if(seen[curr]){
                continue;
            }

            while(!st.isEmpty() && st.peek() > ch && i < lastidx[st.peek() - 'a']){
                seen[st.peek() - 'a'] = false;
                st.pop();
            }
            st.push(ch);
            seen[curr] = true;
        }
        StringBuilder res = new StringBuilder();
        for(char ch : st){
            res.append(ch);
        }
        return res.toString();
        
    }
}
