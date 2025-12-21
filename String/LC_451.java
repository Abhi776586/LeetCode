package String;
import java.util.*;
class Solution {
    public String frequencySort(String s) {
        int n = s.length();

        Map<Character , Integer> freq = new HashMap<>();
        for(char c : s.toCharArray()){
        freq.put(c , freq.getOrDefault(c , 0) + 1);
        }
        
        @SuppressWarnings("unchecked")
        List<Character>[] buckets = new List[n + 1];
        for(char c : freq.keySet()){
            int f = freq.get(c);
            if(buckets[f] == null){
                buckets[f] = new ArrayList<>();
            }
            buckets[f].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = n ; i >= 1; i--){
            if(buckets[i] != null){
                for(char c : buckets[i]){
                    for(int j = 0 ; j < i; j++){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();   
    }
}
