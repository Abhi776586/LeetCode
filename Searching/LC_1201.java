package Searching;
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {

        long A = a ,B = b , C = c;
        long ab = lcm(A , B);
        long ac = lcm(A , C);
        long bc = lcm(B , C);
        long abc = lcm(ab , C);

        long left = 1;
        long right = (long) n * (long) Math.min(a , Math.min(b , c));

        while(left < right){
            long mid = left + (right - left)/2;
            if(count(mid , A , B , C, ab , bc , ac, abc) >= n){
                right = mid ;
            }
            else{
                left = mid + 1;
            }
        }
        return (int)left;  
    }
    private long count(long X , long a , long b , long c , long ab , long bc , long ac , long abc){
        return X/a + X/b + X/c - X/ab - X/bc -X/ac +X/abc;
    }

    private long gcd(long x, long y){
        while(y != 0){
            long temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    private long lcm(long x , long y){
        return (long) x / gcd(x , y) * y;
    }
}
