package problem;

/**
 * problem23:二叉搜索树的后序遍历序列
 * description:输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * Created by wtwang on 2019/5/14.
 */
public class Problem23 {
    public static void main(String[] args){
        int[] sequence = {7,4,6,5};
        System.out.println(VerifySquenceOfBST(sequence));
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return help(sequence,0,sequence.length-1);
    }

    //二叉搜索树后序遍历特征为根结点在最后，左子树在左半部分，右子树在右半部分
    public static boolean help(int[] sequence,int start,int end){
        if(start >= end){
            return true;
        }
        int root = sequence[end];
        int leftEnd = start,rightStart = start;
        boolean set = false;
        for(int i=start;i<end;++i){
            //找出左子树和右子树的分界点
            if(sequence[i] < root){
                leftEnd = i;
            }else if(sequence[i] > root){
                set = true;
                rightStart = i;
                break;
            }
        }
        //set用来设置右子树开始位置
        if(!set) {
            rightStart = leftEnd + 1;
        }
        //检查右子树是否都是大于根结点
        for(int i=rightStart;i<end;++i){
            if(sequence[i] < root){
                return false;
            }
        }
        return help(sequence,start,leftEnd) && help(sequence,rightStart,end-1);
    }
}
