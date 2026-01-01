package Stack;
import java.util.Stack;
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
 
        int[] heights = new int[cols];
        int maxArea = 0;
        for(int i = 0 ; i < rows; i++){
            for(int j = 0 ; j < cols; j++){
                if(matrix[i][j] == '1'){
                    heights[j] += 1;
                }
                else{
                    heights[j] = 0;
                }
            }
           maxArea = Math.max(maxArea , largestRectangleArea(heights));
        }
        return maxArea;


        
    }

    private int largestRectangleArea(int[] heights){
        int n = heights.length;
        Stack<Integer> s = new Stack<>();

        int[] right = new int[n];
        int[] left = new int[n];

        //right smaller
        for(int i = n - 1 ; i >= 0 ; i--){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            right[i] = s.isEmpty() ? n : s.peek(); 
            s.push(i);
        }
        s.clear();

        //left samller
         for(int i = 0 ; i < n  ; i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]){
                s.pop();
            }
            left[i] = s.isEmpty() ? -1 : s.peek(); 
            s.push(i);
        }

        int ans = 0;
        for(int i = 0 ; i < n; i++){
            int width = right[i] - left[i] - 1;
            int currArea = heights[i] * width;
            ans = Math.max(ans ,currArea);
        }
        return ans;
    }
}
