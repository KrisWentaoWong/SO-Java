package problem;

import java.util.Stack;

/**problem5:用两个栈实现队列
 * description:用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * Created by kriswong on 2019/5/10.
 */
public class Problem5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * push操作将元素放入stack1
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 队列的pop操作需要将最先入栈的元素出栈，所以需要将stack1中的元素出栈进入stack2，
     * 然后将stack2栈顶元素出栈，再将stack2的元素重新入栈进入stack1
     * @return
     */
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return res;
    }
}
