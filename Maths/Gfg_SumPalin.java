public class Gfg_SumPalin {
    // User function Template for Java

class Solution {
    boolean isDigitSumPalindrome(int n) {
        int sum = 0;
       while(n > 0){
           int temp = n % 10;
           n = n/10;
           sum += temp;
       }
       int rev = 0;
       int original = sum;
       while(sum > 0){
           int digit = sum % 10;
           rev = rev * 10 + digit;
           sum = sum /10;
       }
       return original == rev;
        
    }
}
}
