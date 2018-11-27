package _155_MinStack;

import java.util.Stack;

class MinStack {
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    private Stack<Integer> aStack;
    /** initialize your data structure here. */
    public MinStack() {
        this.aStack = new Stack<>();
    }

    public void push(int x) {
        if(aStack.empty()){
            aStack.push(x);
            aStack.push(x);
        }else{
            if(x <= aStack.peek()){
                aStack.push(x);
                aStack.push(x);
            }else{
                int min = aStack.peek();
                aStack.push(x);
                aStack.push(min);
            }
        }
    }

    public void pop() {
        aStack.pop();
        aStack.pop();
    }

    public int top() {
        int min = aStack.peek();
        aStack.pop();
        int top = aStack.peek();
        aStack.push(min);
        return top;
    }

    public int getMin() {
        return aStack.peek();
    }
}

public class MainClass {
}


