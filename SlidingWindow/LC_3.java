package SlidingWindow;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];
        int left = 0 , right = 0;
        int ans = 0;
        while(right < s.length()){
            count[s.charAt(right)]++;
            while(count[s.charAt(right)] > 1){
                count[s.charAt(left)]--;
                left++;
            }
            ans = Math.max(ans , right - left + 1);
            right++;
        }
        return ans;
        
    }
}