package dataStructureAndAlgorithm.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的非递归前序遍历
 * Created by wtwang on 2019/6/19.
 */
public class PreOrderTraverseOfBinaryTree {
    public List<Integer> PreOrderTraverse(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //初始栈为空，如果根节点为空，则直接返回
        while(!stack.isEmpty() || cur != null){
            //找到最左节点å
            //对于每一个节点，先将当前节点的值输出到list只能够，将当前节点入栈，访问当前节点的左子节点，直到左子节点为空
            while(cur != null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            //此时cur为空，如果栈不为空，则栈顶元素为最左节点，因为栈顶元素的左子节点为空，访问右子节点
            if(!stack.isEmpty()){
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return list;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
