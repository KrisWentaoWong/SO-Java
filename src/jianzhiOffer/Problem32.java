package jianzhiOffer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * problem32:把数组排成最小的数
 * description:输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * Created by wtwang on 2019/5/14.
 */
public class Problem32 {
    public static void main(String[] args){
        int[] numbers = {321,3,32};
        System.out.println(PrintMinNumber(numbers));
    }
    public static String PrintMinNumber(int[] numbers) {
        String[] ns = new String[numbers.length];
        for(int i=0;i<numbers.length;++i){
            ns[i] = String.valueOf(numbers[i]);
        }
        sort(ns);
        int l = ns.length;
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<l;++i){
            sb.append(ns[i]);
        }
        return sb.toString();
    }

    public static void sort(String[] ns){
        //定义新的排序规则，两个字符串s1和s2，如果s1s2 < s2s1，那么s1<s2
        Arrays.sort(ns, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                int l = s1.length();
                for(int i=0;i<l;++i){
                    if(s1.charAt(i) < s2.charAt(i)){
                        return -1;
                    }else if(s1.charAt(i) > s2.charAt(i)){
                        return 1;
                    }
                }
                return 0;
            }
        });
    }
}
