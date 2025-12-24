package Recursions;
class Solution {

    private long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {

        long evenCount = (n + 1)/2;
        long oddCount = n / 2;

        long first = pow(5, evenCount)%MOD;
        long second = pow(4 , oddCount)%MOD;

        return (int)((first * second)%MOD);
    
    }
    private long pow(long x , long n){
        if(n == 0) return 1;

        long temp = pow(x , n /2);

        if(n % 2 == 0){
            return (temp * temp)%MOD;
        }
        else{
            return (x * temp * temp)%MOD;
        }
    }
}