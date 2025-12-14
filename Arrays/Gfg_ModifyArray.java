package Arrays;
class Solution{
    public static void modifyArray(int[] arr) {
        int n = arr.length;
        for(int i = 0 ; i < n; i++){
            int j = arr[j] % n;
            arr[i] += i * n; 
               }
        for(int i = 0 ; i < n; i++){
            arr[i] /= n ;
      }
}
}
