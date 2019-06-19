package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * problem24:二叉树中和某一值的路径
 * description:输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * Created by wtwang on 2019/5/14.
 */
public class Problem24 {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        root.left = node2;
        root.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.left = node6;
        node5.right = node7;
    }

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        Stack<Integer> stack = new Stack<>();
        if(root != null){
            help(root,sum,0,stack,res);
        }
        return res;
    }

    public void help(TreeNode root,int sum,int curSum,Stack<Integer> stack,List<List<Integer>> res){
        //将当前节点值加到路径和中
        curSum += root.val;
        //将当前节点入栈
        stack.push(root.val);
        //如果当前节点是叶节点，判断路径和是否满足要求
        if(root.left == null && root.right == null){
            if(curSum == sum){
                //遍历当前栈，得到路径
                List<Integer> list = new ArrayList<>();
                int size = stack.size();
                for(int i=0;i<size;++i){
                    list.add(stack.get(i));
                }
                res.add(list);
            }
        }
        //如果当前节点不是叶节点，则需要访问其左子树和右子树
        if(root.left != null){
            help(root.left,sum,curSum,stack,res);
        }
        if(root.right != null){
            help(root.right,sum,curSum,stack,res);
        }
        //将当前节点出栈
        stack.pop();
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
