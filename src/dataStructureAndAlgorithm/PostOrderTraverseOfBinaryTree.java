package dataStructureAndAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的非递归后序遍历
 * Created by wtwang on 2019/6/19.
 */
public class PostOrderTraverseOfBinaryTree {
    public static void main(String[] args){
        PostOrderTraverseOfBinaryTree test = new PostOrderTraverseOfBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node2;
        node2.left = node3;
        List<Integer> list = test.PostOrderTraverse(root);
        list.forEach(System.out::println);
    }
    public List<Integer> PostOrderTraverse(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return list;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while(!stack.isEmpty() || pre == null){
            //找到最左节点
            while(cur != null && pre != cur){
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.peek();
                //当前节点的右子节点为空或已经访问了右子节点，则访问当前节点
                if(cur.right == null || pre == cur.right){
                    pre = cur;
                    list.add(cur.val);
                    stack.pop();
                }
                //当前节点的右子节点不为空并且还未访问，访问右子节点
                else{
                    cur = cur.right;
                }
            }
        }
        return list;
    }
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
