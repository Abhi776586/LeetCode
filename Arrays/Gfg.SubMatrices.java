package Arrays;
class Solution {
    public int submatriceSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for(int i = 0 ; i < mat.length; i++){
            for(int j = 0 ; j < mat.length; j++){
               sum += mat[i][j] * (i + 1) * (j + 1) * (n - i) * (n - j); 
            }
        }
        return sum;
    }
}

