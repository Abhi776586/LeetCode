import java.util.ArrayList;
import java.util.Collections;

public class Gfg_Div {
    class Solution {
    public static void print_divisors(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 1 ; i * i <= n ; i++){
            if(n % i == 0){
                result.add(i);
                if(i != n/i){
                    result.add(n/i);
                }
            }
        }
        Collections.sort(result);
        for(int x : result){
            System.out.print(x + " ");
        }
    }
}

    
}
