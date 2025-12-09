package Sorting;
class Solution {
    void segregateEvenOdd(int arr[]) {
        int n = arr.length;
        
        int j = 0;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] % 2 == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        
        if(j > 0){
            quickSort(arr , 0 , j - 1);
        }
        if(j < n) {
            quickSort(arr , j , n - 1);
        }
        
    }
    private void quickSort(int arr[] , int l , int r){
        if(l >= r){
            return;
        }
        
        int p =  partition(arr, l , r);
        
        quickSort(arr, l , p - 1);
        quickSort(arr, p + 1 , r);
        
    }
    private int partition(int arr[] , int l , int r){
        int pivot = arr[r];
        int i = l - 1;
        
        for(int j = l ; j <  r ; j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
        
        return i + 1;
    }
        
    
}