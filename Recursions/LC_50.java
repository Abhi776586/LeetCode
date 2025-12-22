package Recursions;
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }
        double ans = 1;
        while(N > 0){
            if(N % 2 == 1){
                ans = ans * x;
            }
            x *= x;
            N= N/2;
        
        }
        return ans;
        
    }

    public double myPowRecursive(double x, int n) {
        long N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }
        return fastPow(x , N);
    }
    private double fastPow(double x , long n){

        if(n == 0) return 1.0;
        double half = fastPow(x , n/2);
        if(n % 2 == 0){
            return half * half;
        }
        else{
            return half * half * x;
        }

    }
}

