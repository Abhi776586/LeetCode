package Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
class Result {

    public static List<Integer> getMax(List<String> operations) {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();
    List<Integer> result = new ArrayList<>();
    for(int i = 0; i< operations.size(); i++){
        String op = operations.get(i);
        
        String[] parts = op.split(" ");
        int type = Integer.parseInt(parts[0]);
        if(type == 1){
            int x =Integer.parseInt(parts[1]);
            stack.push(x);
            if(maxStack.isEmpty() || x >= maxStack.peek()){
                maxStack.push(x);
            }
        }
        
        else if(type == 2){
            int removed = stack.pop();
            if(removed == maxStack.peek()){
                maxStack.pop();
            }
        }
        else{
            result.add(maxStack.peek());
        }
    }
    return result;
    

    }

}