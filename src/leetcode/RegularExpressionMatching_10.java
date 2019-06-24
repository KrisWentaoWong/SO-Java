package leetcode;

/**
 * Created by wtwang on 2019/6/24.
 */
public class RegularExpressionMatching_10 {
    public boolean isMatch(String s, String p) {
        int l1 = s.length(),l2 = p.length();
        if(l1 == 0 && l2 == 0){
            return true;
        }
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        //处理a*b*开头的模式串，此时空串是可以匹配的
        for(int j=0;j<l2;++j){
            if(p.charAt(j) == '*'){
                dp[0][j+1] = dp[0][j-1];
            }
        }

        //i表示输入串的下标，j表示模式串的下标
        for(int i=0;i<l1;++i){
            for(int j=0;j<l2;++j){
                //如果输入串的当前字符和模式串的当前字符匹配，或者模式串的字符为'.'，因为'.'可以匹配任意字符，所以也是匹配的情况
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                    dp[i+1][j+1] = dp[i][j];
                }
                //如果模式串的当前字符是'*'，需要分情况
                else if(p.charAt(j) == '*'){
                    //如果输入串的当前字符和模式串中前一个字符不想等，即类似于b和a*的情况，那么a*的取值为空
                    if(s.charAt(i) != p.charAt(j-1)){
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }
                    //如果输入串的当前字符和模式串的前一个字符相等，或者模式串的前一个字符为'.'，即匹配状态，类似于a和a*的情况，那么此时a*可以有空串，单个a和多个a三种情况，都可能匹配
                    if(s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                        dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1];
                    }
                }else{
                    dp[i+1][j+1] = false;
                }
            }
        }
        return dp[l1][l2];
    }
}
