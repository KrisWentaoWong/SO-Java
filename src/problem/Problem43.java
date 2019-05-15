package problem;

/**
 * problem43:左旋转字符串
 * description:汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * Created by wtwang on 2019/5/15.
 */
public class Problem43 {
    public String LeftRotateString(String str,int n) {
        int length = str.length();
        if(length == 0){
            return "";
        }
        n = n%length;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<length;++i){
            sb.append(str.charAt((i+n)%length));
        }
        return sb.toString();
    }
}
