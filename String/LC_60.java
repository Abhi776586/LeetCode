package String;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();
        for(int i = 1 ; i < n ; i++){
            fact = fact * i;
            nums.add(i);
        }
        nums.add(n);

        // int[] fact = new int[n];
        // fact[0] = 1;
        // for(int i = 1; i < n; i++){
        //     fact[i] = i * fact[i - 1];
        // }

        k = k - 1;
        String ans = "";
        while(true){
            ans = ans + nums.get(k / fact);
            nums.remove(k / fact);
            if(nums.size() == 0){
                break;
            }
            k = k % fact;
            fact = fact / nums.size();
        }
        return ans;  
    }
}