package dataStructureAndAlgorithm.dataStructure.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的非递归中序遍历
 * Created by wtwang on 2019/6/19.
 */
public class InOrderTraverseOfBinaryTree {
    public List<Integer> InOrderTraverse(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            //找到最左节点
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //栈不为空时，栈顶元素即为最左节点，将最左节点的值输出到list中
            if(!stack.isEmpty()){
                cur = stack.pop();
                list.add(cur.val);
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
