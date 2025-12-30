package Stack;
import java.util.Stack;
class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            st.push(i);
        }
        
        while(st.size() > 1){
            int i = st.pop();
            int j = st.pop();
            
            if(mat[i][j] == 0){
                st.push(i);
            }
            else{
                st.push(j);
            }
        }
        
        int celeb = st.peek();
        for(int i = 0 ; i < n; i++){
            if((i != celeb) && (mat[i][celeb] == 0 || mat[celeb][i] == 1)) return -1;
        }
        return celeb;
        
        
    }
}