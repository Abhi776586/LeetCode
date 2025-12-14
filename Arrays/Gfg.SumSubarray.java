package Arrays;
class Solution {
    public int subarraySum(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i = 0 ; i < arr.length; i++){
            sum += arr[i] * (i + 1) * (n - i);
        }
        return sum;
    }
}
