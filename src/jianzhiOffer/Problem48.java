package jianzhiOffer;

/**
 * problem48:不用加减乘除做加法
 * description:写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * Created by wtwang on 2019/5/15.
 */
public class Problem48 {
    public static void main(String[] args){
        System.out.println(Add(3,8));
    }

    /**
     * 二进制的加法即为按位异或再考虑进位
     * @param num1
     * @param num2
     * @return
     */
    public static int Add(int num1,int num2) {
        //c为需要进位的位，即num1和num2均位1的位需要进位，效果是下一位多一个1，所以需要左移一位
        int c = (num1 & num2) << 1;
        //异或不考虑进位，直接相加
        int xor = num1 ^ num2;
        //如果进位是0，那么异或的结果就是最终相加的结果
        while(c != 0) {
            //如果进位不是0，则需要将异或的结果和进位相加，是一个递归的过程
            int temp = c;
            c = (c & xor) << 1;
            xor = temp ^ xor;
        }
        return xor;
    }
}
