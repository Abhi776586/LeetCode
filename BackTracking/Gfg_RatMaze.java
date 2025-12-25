package BackTracking;
import java.util.ArrayList; 
class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> result = new ArrayList<>();
        String path = "";
        solve(maze, 0, 0, path, result);
        return result;
    }

    private void solve(int[][] maze, int r, int c,
                       String path, ArrayList<String> result) {

        int n = maze.length;

        if (r < 0 || c < 0 || r >= n || c >= n ||
            maze[r][c] == 0 || maze[r][c] == -1) {
            return;
        }

        if (r == n - 1 && c == n - 1) {
            result.add(path);
            return;
        }

        maze[r][c] = -1;

        solve(maze, r + 1, c, path + "D", result);
        solve(maze, r, c - 1, path + "L", result);
        solve(maze, r, c + 1, path + "R", result);
        solve(maze, r - 1, c, path + "U", result);

        maze[r][c] = 1;
    }
}
