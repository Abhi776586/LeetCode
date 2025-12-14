package Arrays;
class Solution{
    public static void modifyArray(int[] arr) {
        int n = arr.length;
        for(int i = 0 ; i < n; i++){
            int j = arr[i] % n;
            arr[j] += i * n; 
               }
        for(int i = 0 ; i < n; i++){
            arr[i] /= n ;
      }
}
}
