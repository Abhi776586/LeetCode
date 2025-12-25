package TwoPointer;
class Solution {
    public int maxArea(int[] height) {
        int maxwater = 0;
        int left = 0 , right = height.length - 1;
        while(left < right){
            int w = right - left;
            int ht = Math.min(height[left] , height[right]);
            int current = w * ht;
            maxwater = Math.max(maxwater , current);

            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxwater;
    }
}