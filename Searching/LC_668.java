package Searching;
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m * n;

        while(low < high){
           int mid = low + (high - low)/2;
           int count = countLessEqual(m , n , mid);
           if(count >= k){
            high = mid;
           }
           else{
            low = mid + 1;
           }
            
           }
        return low;
}
        private int countLessEqual(int m , int n , int x){
            int count = 0;
            for(int i = 1; i <= m ; i++){
                int multiples = x / i;
                if(multiples > n){
                    multiples = n;
                }
                count += multiples;

            }
            return count;
        }
}