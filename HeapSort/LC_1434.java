package HeapSort;
import java.util.*;
class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0 , max2 = 0;

        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] > max1){
                max2 = max1;
                max1 = nums[i];
            }
            else if(nums[i] > max2){
                max2 = nums[i];
            }
        }
        return (max1 - 1) * (max2 - 1);
        
    }
    public int maxHeapProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    

        for(int i = 0 ; i < nums.length; i++){
            pq.offer(nums[i]);
        }
        int max1 = pq.poll();
        int max2 = pq.poll();

        return (max1 - 1) * (max2 - 1);

            
        
    }
}

