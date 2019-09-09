package fiftyquestions;

import java.util.Stack;

public class ReverseStack {

    public Stack<Integer> reverseStack (Stack <Integer> stack){
        if(stack == null) throw new IllegalArgumentException();
        if(stack.isEmpty()) return stack;
        Integer temp = stack.pop();
        reverseStack(stack);
        insertAtBottom(stack, temp);
        return stack;
    }
    private void insertAtBottom(Stack<Integer> stack, int x){
        if(stack.isEmpty()){
            stack.push(x);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, x);
        stack.push(temp);
    }
}

