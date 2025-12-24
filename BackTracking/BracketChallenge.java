package BackTracking;
import java.util.*;

class Solution {

public List<String> generateBrackets(int n, int m) {
        List<String> result = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();

        solve("", n, n, m, m, stack, result);
        return result;
    }
    
    static void solve(String curr , int openParen , int closeParen , int openBrace , int closeBrace , Deque<Character> stack , List<String> result){
        
        if(openParen == 0 && closeParen == 0 && openBrace == 0 && closeBrace == 0 && stack.isEmpty()){
           result.add(curr);
           return;
        }
        
        if(openParen > 0){
            stack.push('(');
            solve(curr + "(" , openParen - 1 , closeParen , openBrace , closeBrace , stack , result);
            stack.pop();
        }
        
        if(openBrace > 0){
            stack.push('{');
            solve(curr + "{" , openParen , closeParen , openBrace - 1 , closeBrace , stack , result);
            stack.pop();
        }
        
        if(closeParen > 0 && !stack.isEmpty() && stack.peek() == '('){
            stack.pop();
            solve(curr + ")" , openParen , closeParen - 1, openBrace , closeBrace , stack , result);
            stack.push('(');
        }
        
        if(closeBrace > 0 && !stack.isEmpty() && stack.peek() == '{'){
            stack.pop();
            solve(curr + "}" , openParen , closeParen , openBrace , closeBrace - 1 , stack , result);
            stack.push('{');
        }
        
        
    }
}
