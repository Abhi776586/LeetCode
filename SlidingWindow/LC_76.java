package SlidingWindow;
import java.util.HashMap;
class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character , Integer> need = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            need.put(c ,need.getOrDefault(c , 0) + 1);
        }
        
        int formed = 0;
        int required = need.size();

        int left = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for(int right = 0 ; right < s.length(); right++){
            char c = s.charAt(right);
            if(need.containsKey(c)){
            need.put(c , need.get(c) - 1);
            if(need.get(c) == 0)
            formed++;
        }

        while(formed == required){
            if(right - left + 1 < minLen){
                minLen = right - left + 1;
                start = left;
            }

            char leftchar = s.charAt(left);
            if(need.containsKey(leftchar)){
                need.put(leftchar , need.get(leftchar) + 1);
                if(need.get(leftchar) > 0)
                formed--;
            }
            left++;
        }
    }
    return minLen == Integer.MAX_VALUE ? "" : s.substring(start , start + minLen);
    }
}
