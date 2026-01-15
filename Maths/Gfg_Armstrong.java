public class Gfg_Armstrong {
    // User function Template for Java
class Solution {
    static boolean armstrongNumber(int n) {
        int sum = 0;
        int original = n;
        while(n > 0){
            int temp = n % 10;
            n = n /10;
            sum += temp * temp * temp;
        }
        return sum == original;
        
    }
}
}
