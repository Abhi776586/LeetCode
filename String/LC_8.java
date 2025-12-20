package String;
class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        if(n == 0) return 0;

        int i = 0;
        while(i < n && s.charAt(i) == ' '){
            i++;
        }

        int sign = 1;
        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        long ans = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        while(i < n && Character.isDigit(s.charAt(i))){
            ans = ans * 10 + s.charAt(i) - '0';
            if(sign == -1 && -1 * ans < min) return min;
            if(sign == 1 &&  ans > max) return max;

            i++;
        }
        return (int)(sign * ans);

        
    }
}