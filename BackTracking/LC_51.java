package BackTracking;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(board[i] , '.');
        }
        Nqueens(board , 0 , n , result);
        return result;
    }

    private void Nqueens(char[][] board , int row , int n , List<List<String>> result){
        if(row == n){
            List<String> current = new ArrayList<>();
            for(char[] c : board){
                current.add(new String(c));
            }
            result.add(current);
            return;
        }
        for(int j = 0 ; j < n ; j++){
            if(isSafe(board , row , j , n )){
            board[row][j] = 'Q';
            Nqueens(board , row + 1 , n ,result);
            board[row][j] = '.';
            }

        }
    }
    private boolean isSafe(char[][] board , int row , int col , int n){
        //horizontal
        for(int j = 0 ; j < n ; j++){
            if(board[row][j] == 'Q'){
                return false;
            }
        }

        //vertical
        for(int i = 0 ; i < n ; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        // leftdiagonal
        for(int i = row, j = col ; i >= 0 && j >= 0; i-- , j-- ){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //Right diagonal
        for(int i = row, j = col ; i >= 0 && j < n; i-- , j++ ){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
