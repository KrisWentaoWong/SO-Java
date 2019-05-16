package problem;

/**
 * problem53:表示数值的字符串
 * description:请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * Created by wtwang on 2019/5/16.
 */
public class Problem53 {
    public static void main(String[] args){
//        char[] str = "+100".toCharArray();
//        char[] str = "5e2".toCharArray();
//        char[] str = "3.1416".toCharArray();
        char[] str = "12e+4.3".toCharArray();
//        char[] str = "+-5".toCharArray();
//        char[] str = "1.2.3".toCharArray();
//        char[] str = "1a3.14".toCharArray();
//        char[] str = "12e".toCharArray();
//        char[] str = "-1E-16".toCharArray();
        System.out.println(isNumeric(str));
    }
    public static boolean isNumeric(char[] str) {
        String s = String.valueOf(str).toUpperCase();
        //判断是否有e，有几个e
        int count = 0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i) == 'E'){
                count++;
            }
        }
        //有两个e，非法
        if(count >= 2){
            return false;
        }
        //没有e
        else if(count == 0){
            return judgePureNum(s,1);
        }
        //有1个e
        else{
            String[] parts = s.split("E");
            if(parts.length == 1){
                return false;
            }else{
                String first = parts[0];
                String second = parts[1];
                //由e区分的，前半部分可以为整数和小数，后半部分只能为整数
                return judgePureNum(first,1) && judgePureNum(second,0);
            }
        }
    }

    /**
     * 判断是否是整数或小数
     * @param s
     * @param flag 用来区分整数和小数，flag的意义为小数点的个数，flag=0时为整数，flag=1时为小数
     * @return
     */
    public static boolean judgePureNum(String s,int flag){
        if(s.length() == 0){
            return false;
        }
        //如果有符号，一定是在第一位
        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            s = s.substring(1,s.length());
        }
        if(s.length() == 0){
            return false;
        }
        //可以为整数或者小数
        // TODO: 2019/5/16 小数点前后没有数字的情况，如".15"或"1."，目前这两种情况都合法
        int count = 0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i) == '.'){
                count++;
                //如果小数点个数超过限定的个数，为非法
                if(count > flag){
                    return false;
                }
            }else if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }
}
