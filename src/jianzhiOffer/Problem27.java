package jianzhiOffer;

import java.util.ArrayList;

/**
 * problem27:字符串的排列
 * description:输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * Created by wtwang on 2019/5/14.
 */
public class Problem27 {
    public static void main(String[] args){
        String test = "";
        Permutation(test);
    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if(str.equals("")){
            return list;
        }
        help(list,new String(""),str,new boolean[str.length()]);
        return list;
    }

    public static void help(ArrayList<String> list,String cur,String str,boolean[] used){
        if(cur.length() == str.length()){
            list.add(new String(cur));
        }else{
            for(int i=0;i<str.length();++i){
                if(used[i] || i>0 && str.charAt(i) == str.charAt(i-1) && !used[i-1]) {
                    continue;
                }
                cur += str.charAt(i);
                used[i] = true;
                help(list,cur,str,used);
                used[i] = false;
                cur = cur.substring(0,cur.length()-1);

            }
        }
    }
}
