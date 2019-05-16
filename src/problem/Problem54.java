package problem;

import java.util.ArrayList;
import java.util.List;

/**
 * problem54:字符流中第一个不重复的字符
 * description:请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * Created by wtwang on 2019/5/16.
 */
public class Problem54 {
    int[] arr = new int[256];
    List<Character> list = new ArrayList<>();
    //Insert one char from stringstream
    public void Insert(char ch) {
        list.add(ch);
        arr[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for(int i=0;i<list.size();++i){
            if(arr[list.get(i)] == 1){
                return list.get(i);
            }
        }
        return '#';
    }
}
