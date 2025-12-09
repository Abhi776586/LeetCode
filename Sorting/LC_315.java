class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if(n == 0) return ans;

        int[] index = new int[n];
        int[] result = new int[n];

        for(int i = 0 ; i < n ; i++){
            index[i] = i;
        }

        mergeSort(nums, index , 0 , n -1 , result);
              for(int x : result){
                ans.add(x);
              }
              return ans;
        }
        private void mergeSort(int[] nums , int[] index , int l , int r , int[] result){
            if(l >= r) return;

            int mid = l + (r - l)/2;
            mergeSort(nums , index , l , mid ,result);
            mergeSort(nums , index , mid + 1 , r , result);

            merge(nums , index , l , mid , r , result);
        }
        private void merge(int[] nums , int[] index , int l , int mid, int r ,int[] result){
            int len1 = mid - l + 1;
            int len2 = r - mid;

            int left[] = new int[len1];
            int right[] = new int[len2];

            for(int i = 0 ; i < len1; i++){
                left[i] = index[l + i];
            }

            for(int j = 0; j < len2; j++){
                right[j] = index[mid + 1 + j];
            }

            int i = 0;
            int j = 0;
            int k  = l;
            int rightCount = 0;
            while(i < len1 && j < len2){
                if(nums[right[j]] < nums[left[i]]){
                       rightCount++;
                       index[k++] = right[j++];
                }
                else{
                   result[left[i]] += rightCount;
                   index[k++] = left[i++];
                }
            }
            while(i < len1){
                result[left[i]] += rightCount;
                index[k++] = left[i++];
            }
            while(i < len2){
                index[k++] = right[j++];
            }
        }
}