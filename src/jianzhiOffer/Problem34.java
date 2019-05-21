package jianzhiOffer;

import java.util.HashMap;

/**
 * problem34:第一个只出现一次的字符
 * description:在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符，
 * 并返回它的位置， 如果没有则返回 -1（需要区分大小写）。
 * Created by wtwang on 2019/5/15.
 */
public class Problem34 {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<str.length();++i){
            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),1);
            }else{
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }
        }
        for(int i=0;i<str.length();++i){
            if(map.get(str.charAt(i)) ==  1){
                return i;
            }
        }
        return -1;
    }
}
