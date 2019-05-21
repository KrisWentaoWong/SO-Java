package jianzhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * problem3:从尾到头打印链表
 * description:输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * Created by wtwang on 2019/5/10.
 */
public class Problem3 {
    /**
     * 先顺序遍历将值存入栈中，再依次出栈到列表中
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null){
            return list;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode cur = listNode;
        while(cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;

    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


