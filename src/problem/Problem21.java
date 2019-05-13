package problem;

import java.util.Stack;

/**
 * problem21:栈的压入、弹出序列
 * description:输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * Created by wtwang on 2019/5/13.
 */
public class Problem21 {
    public static void main(String[] args){
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};
        System.out.println(IsPopOrder(pushA,popA));
    }

    static Stack<Integer> stack = new Stack<>();
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        int j=0;
        for(int i=0;i<popA.length;++i){
            int cur = popA[i];
            //如果栈顶元素不是popA的下一个元素，则将pushA的元素入栈
            while((stack.isEmpty() || stack.peek() != cur) && j<pushA.length){
                stack.push(pushA[j]);
                j++;
            }
            if(stack.peek() == cur){
                stack.pop();
            }else{
                return false;
            }
        }
        return true;
    }
}
