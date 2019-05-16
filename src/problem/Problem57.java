package problem;

import java.util.ArrayList;
import java.util.List;

/**
 * problem57:二叉树的下一个节点
 * description:给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * Created by wtwang on 2019/5/16.
 */
public class Problem57 {
    public static void main(String[] args){
        TreeLinkNode node8 = new TreeLinkNode(8);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node10 = new TreeLinkNode(10);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node7 = new TreeLinkNode(7);
        TreeLinkNode node9 = new TreeLinkNode(9);
        TreeLinkNode node11 = new TreeLinkNode(11);
        node8.left = node6;
        node8.right = node10;
        node6.next = node8;
        node10.next = node8;
        node6.left = node5;
        node6.right = node7;
        node5.next = node6;
        node7.next = node6;
        node10.left = node9;
        node10.right = node11;
        node9.next = node10;
        node11.next = node10;
        System.out.println(GetNext(node10).val);
    }

    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        /**
         * 右子节点为空：
         * 1.当前节点是父节点的左子节点，则下一节点为父节点
         * 2.当前节点是父节点的右子节点，迭代寻找下一节点
         * 右子节点不为空：则下一节点为右子节点中的最左节点
         */
        if(pNode.right == null){
            if(pNode.next == null){
                return null;
            }else{
                if(pNode.next.left == pNode){
                    return pNode.next;
                }
                else{
                    TreeLinkNode cur = pNode.next;
                    while(cur != null && cur.next != null && cur.next.right == cur){
                        cur = cur.next;
                    }
                    return cur.next;
                }
            }
        }else{
            TreeLinkNode cur = pNode.right;
            while(cur.left != null){
                cur = cur.left;
            }
            return cur;
        }
    }

    static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
