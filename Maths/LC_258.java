class Solution {
    public int addDigits(int num) {
        if(num == 0) return 0;
        elcse return 1 + (num - 1) % 9;
    }
}