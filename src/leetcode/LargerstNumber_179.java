package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by wtwang on 2019/6/24.
 */
public class LargerstNumber_179 {
    public String largestNumber(int[] nums) {
        String[] ns = new String[nums.length];
        for(int i=0;i<nums.length;++i){
            ns[i] = String.valueOf(nums[i]);
        }
        sort(ns);
        int l = ns.length;
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<l;++i){
            sb.append(ns[i]);
        }
        String res = sb.toString();
        int resl = res.length();
        //额外处理全是0的结果
        for(int i=0;i<resl;++i){
            if(res.charAt(i) != '0'){
                return res;
            }
        }
        return "0";
    }

    public static void sort(String[] ns){
        //定义新的排序规则，两个字符串s1和s2，如果s1s2 > s2s1，那么s1<s2
        Arrays.sort(ns, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                int l = s1.length();
                for(int i=0;i<l;++i){
                    if(s1.charAt(i) > s2.charAt(i)){
                        return -1;
                    }else if(s1.charAt(i) < s2.charAt(i)){
                        return 1;
                    }
                }
                return 0;
            }
        });
    }
}
