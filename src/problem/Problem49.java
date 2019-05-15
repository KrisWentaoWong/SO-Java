package problem;

/**
 * problem49:把字符串转换成整数
 * description:将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * Created by wtwang on 2019/5/15.
 */
public class Problem49 {
    public static void main(String[] args){
        String s = "-2147483647";
        System.out.println(StrToInt(s));
    }

    public static int StrToInt(String str) {
        //消除空格
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }
        int res = 0;
        int flag = 1;
        //判断符号
        if(str.charAt(0) == '-'){
            flag = -1;
            str = str.substring(1,str.length());
        }else if(str.charAt(0) == '+'){
            str = str.substring(1,str.length());
        }

        for(int i=0;i<str.length();++i){
            //如果不是数字，则非法
            if(str.charAt(i) > '9' || str.charAt(i) < '0'){
                return 0;
            }
            res = res * 10 + str.charAt(i) - '0';
        }

        return res*flag;
    }
}
