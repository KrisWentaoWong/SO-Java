package jianzhiOffer;

import java.util.*;

/**
 * problem59:按之字形打印二叉树
 * description:请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * Created by wtwang on 2019/5/16.
 */
public class Problem59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(pRoot != null){
            queue.offer(pRoot);
        }
        int dir = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            Deque<Integer> list = new ArrayDeque<>();
            /**
             * 基于层次遍历，隔行改变方向
             */
            for(int i=0;i<size;++i){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(dir == 1){
                    list.addLast(node.val);
                }else{
                    list.addFirst(node.val);
                }
            }
            ArrayList<Integer> arrList = new ArrayList<>();
            arrList.addAll(list);
            res.add(arrList);
            dir *= -1;
        }
        return res;
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
