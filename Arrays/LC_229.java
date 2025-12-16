package Arrays;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int cand1 = 0 , cand2 = 0;
        int count1 = 0 , count2 = 0;

        for(int i = 0 ; i < n ; i++){
            int num = nums[i];

            if(num == cand1){
                count1++;
            }
            else if(num == cand2){
                count2++;
            }
            else if(count1 == 0){
                cand1 = num;
                count1 = 1;
            }
            else if(count2 == 0){
                cand2 = num;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int i = 0 ; i < n; i++){
            if(nums[i] == cand1){
                count1++;
            }
            else if(nums[i] == cand2){
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        if(count1 > n/3) result.add(cand1);
        if(count2 > n/3) result.add(cand2);
        return result;

    }
}
