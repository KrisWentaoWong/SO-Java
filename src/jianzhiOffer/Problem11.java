package jianzhiOffer;

/**
 * problem11:二进制中1的个数
 * description:输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * Created by wtwang on 2019/5/13.
 */
public class Problem11 {
    public static void main(String[] args){
        System.out.println(NumberOf1(-2));
    }

    public static int NumberOf1(int n) {
        int count = 0;
        //int类型一共32位，依次判断每一位
        for(int i=0;i<32;++i){
            if((n >> i & 1) == 1){
                count++;
            }
        }
        return count;
    }
}
