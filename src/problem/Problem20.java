package problem;

import java.util.Stack;

/**
 * problem20:包含min函数的栈
 * description:定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * Created by wtwang on 2019/5/13.
 */
public class Problem20 {
    Stack<Integer> stack = new Stack<>();
    //维护最小栈，栈中元素满足后入栈的比先入栈的元素小
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        stack.push(node);
        //当最小栈为空或栈顶元素大于当前元素
        if(minStack.isEmpty() || node < minStack.peek()) {
            minStack.push(node);
        }
    }

    public void pop() {
        //如果要出栈的元素为最小元素，则最小栈中也需要出栈
        if(stack.peek() == minStack.peek()) {
            stack.pop();
            minStack.pop();
        }else{
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
