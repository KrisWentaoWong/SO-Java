package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * problem62:二叉搜索树的第k个节点
 * description:给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 * Created by wtwang on 2019/5/16.
 */
public class Problem62 {
    /**
     * 需要额外O(n)空间的解法：构建一个中序遍历数组存放节点
     * O(1)空间的解法：设置一个计数变量，表明当前访问的节点是第几小的节点，如果等于k则所求结果即为当前节点
     */
    List<TreeNode> list = new ArrayList<>();
    int count = 0;
    TreeNode res = null;
    TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot,k);
        return res;
    }

    public void inOrder(TreeNode root,int k){
        if(root == null){
            return;
        }
        inOrder(root.left,k);
        count++;
        if(count == k){
            res = root;
        }
        inOrder(root.right,k);
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
