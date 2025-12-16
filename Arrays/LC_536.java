package Arrays;
class Solution {
    // Solution 1- Brute Force/Sliding Window
    public boolean checkInclusionBrute(String s1, String s2) {
    

        int[] freq = new int[26];

        for(int i = 0 ; i < s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
        }

        int windsize = s1.length(); 

        for(int i = 0 ; i <s2.length(); i++){
            int windIdx = 0 , idx = i;
            int[] windFreq = new int[26];

            while(windIdx < windsize && idx < s2.length()){
                windFreq[s2.charAt(idx) - 'a']++;
                windIdx++;
                idx++;
            }

            if(isFreqsame(freq ,windFreq)){
                return true;
            }
        }
        return false;      
    }

    // Solution 2- Optimized Sliding Window

    public boolean checkInclusion(String s1, String s2) {
    
         if (s1.length() > s2.length()) return false;
        int[] freq = new int[26];

        for(int i = 0 ; i < s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
        }

        int[] windFreq = new int[26];
        int windowSize = s1.length();
        int left = 0; 

        for(int right = 0 ; right <s2.length(); right++){
            windFreq[s2.charAt(right) - 'a']++;

            if(right - left + 1 > windowSize){
                windFreq[s2.charAt(left) - 'a']--;
                left++;
            } 
            
            if(right - left + 1 == windowSize){
            if(matches(freq ,windFreq)){
                return true;
            }
        }
    }
        return false;      
    }
    private boolean isFreqsame(int[] freq1 , int[] freq2){
        for(int i = 0 ; i < 26; i++){
        if(freq1[i] != freq2[i]) return false;
        }
       return true;
    }
     private boolean matches(int[] freq1 , int[] freq2){
        for(int i = 0 ; i < 26; i++){
        if(freq1[i] != freq2[i]) return false;
        }
       return true;
    }
}


