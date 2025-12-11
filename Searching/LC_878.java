package Searching;
class Solution {
    public int nthMagicalNumber(int n, int a, int b) {

        final int MOD = 1_000_000_007;
        long low = Math.min(a , b);
        long high = (long) n * Math.min(a , b);
        long L = lcm(a , b);

        while(low < high){
            long mid = low + (high - low)/2;
            long count = mid/a + mid/b - mid/L;
            if(count >= n){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return (int)(low % MOD);
    }
        private int gcd(int x , int y){
            while(y != 0){
                int temp = y;
                y = x % y;
                x = temp;
            }
            return x;
        }
        private long lcm(int x , int y){
            return (long) x / gcd(x , y) * y;
        }
        
    }
