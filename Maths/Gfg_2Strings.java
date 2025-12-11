import java.math.BigInteger; 
class Solution {
    public String multiplyStrings(String s1, String s2) {
        BigInteger n1 = new BigInteger(s1);
        BigInteger n2 = new BigInteger(s2);
        BigInteger product = n1.multiply(n2);
        String result = String.valueOf(product);
        return result;
    }
}