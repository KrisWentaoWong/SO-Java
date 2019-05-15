package problem;

import java.util.ArrayList;

/**
 * problem41:和为S的连续正数序列
 * description:小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * Created by wtwang on 2019/5/15.
 */
public class Problem41 {
    public static void main(String[] args){
        System.out.println(FindContinuousSequence(9));
    }
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        /**
         * 根据连续正数数列的长度来判断
         * 设连续序列的长度为x,从k处开始，则序列为k,k+1,...,k+x-1
         * 则序列的和为(k+k+x-1)*x/2,即(2k+x-1)*x/2=sum,求得k=(2*sum/x-x+1)/2,满足k是正整数
         * 考虑x的最大值,k为正整数,所以k的最小值为1,则满足(1+2+...+x)<=sum,求的x<=Math.sqrt(8*sum-1)-1)/2
         */

        int k;
        for(int x=(int)(Math.sqrt(8*sum-1)-1)/2+1;x>=2;--x){
            if(2*sum%x == 0 && (2*sum/x - x + 1)%2 == 0 && (2 * sum / x - x + 1)/2 > 0) {
                k = (2 * sum / x - x + 1) / 2;
                ArrayList<Integer> list = new ArrayList<>();
                for(int m=k;m<k+x;++m){
                    list.add(m);
                }
                res.add(list);
            }
        }
        return res;
    }
}
