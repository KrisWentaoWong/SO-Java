package jianzhiOffer;

/**
 * problem47:求1+2+3+...+n
 * description:求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * Created by wtwang on 2019/5/15.
 */
public class Problem47 {
    public static void main(String[] args){
        System.out.println(Sum_Solution(100));
    }

    /**
     * 利用短路与特性，对于a&&b，如果a为false则b不会执行，直接终止条件
     * @param n
     * @return
     */
    public static int Sum_Solution(int n) {
        int sum = 0;
        boolean res = n>0 && (sum=Sum_Solution(n-1)+n)>0;
        return sum;
    }
}
