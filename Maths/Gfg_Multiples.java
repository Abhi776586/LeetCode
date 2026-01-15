import java.util.ArrayList;

public class Gfg_Multiples {
    // User function Template for Java
class Solution {
    static ArrayList<Integer> getTable(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 1 ; i <= 10; i++){
            result.add(n * i);
        }
        return result;      
    }
}
}
