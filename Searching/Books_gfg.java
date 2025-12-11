package Searching;
class Solution {
    public int findPages(int[] arr, int k) {
       int n = arr.length;
       if(k > n) return -1;
       int sum = 0;
       for(int i = 0 ; i < n; i++){
           sum += arr[i];
       }
       
       int low = 0;
       int high = sum;
       int ans = -1;
       while(low <= high){
           int mid = low + (high - low)/2;
           if(isValid(arr , n , k ,mid)){
               ans = mid;
               high = mid - 1;
           }
           else{
               low = mid + 1;
           }
       }
       return ans;
    }
    private boolean isValid(int[] arr , int n , int k , int mid){
        int student = 1;
        int pages = 0;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] > mid) return false;
            
            if(pages + arr[i] <= mid){
                pages += arr[i];
            }
            else{
                student++;
                pages = arr[i];
                if(student > k) return false;
        }
    }
    return true;
}
}