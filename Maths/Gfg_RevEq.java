public class Gfg_RevEq {
    // User function Template for Java
class Solution {

    String reverseEqn(String S) {
       StringBuilder result = new StringBuilder();
       StringBuilder num = new StringBuilder();
       
       for(int i = S.length() - 1 ; i >= 0; i--){
           char ch = S.charAt(i);
           
           if(Character.isDigit(ch)){
               num.insert(0 , ch);
           }
           else{
               result.append(num);
               result.append(ch);
               num.setLength(0);
           }
       }
    result.append(num);
    return result.toString();
    }
}
    
}
