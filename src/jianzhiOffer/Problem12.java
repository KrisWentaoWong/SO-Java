package jianzhiOffer;

/**
 * problem12:数值的整数次方
 * description:给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * Created by wtwang on 2019/5/13.
 */
public class Problem12 {
    public static void main(String[] args){
        System.out.println(Power(2,-3));
    }
    public static double Power(double base, int exponent) {
        double res = 1.0;
        //区分指数可能为负数的情况
        if(exponent > 0) {
            for (int i = 0; i < exponent; ++i) {
                res *= base;
            }
        }else if(exponent < 0){
            for (int i = 0; i < 0-exponent; ++i) {
                res *= 1/base;
            }
        }
        return res;
    }
}
