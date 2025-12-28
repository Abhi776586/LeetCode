package SlidingWindow;
import java.util.HashMap;
class Solution {
    public int longestKSubstr(String s, int k) {
    int left = 0 , maxLen = 0;
    
    HashMap<Character , Integer> map = new HashMap<>();
    
    for(int right = 0 ; right < s.length(); right++){
        char c = s.charAt(right);
        map.put(c , map.getOrDefault(c, 0) + 1);
        
        while(map.size() > k){
            char leftchar = s.charAt(left);
            map.put(leftchar , map.get(leftchar) - 1);
            if(map.get(leftchar) == 0){
                map.remove(leftchar);
            }
            left++;
        }
        if(map.size() == k){
            maxLen = Math.max(maxLen , right -left + 1);
        }
    }
      return maxLen == 0 ? -1 : maxLen;
    }
}
