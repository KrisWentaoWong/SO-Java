package problem;

/**
 * problem2:字符串
 * description:请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * Created by wtwang on 2019/5/10.
 */
public class Problem2 {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ","%20");
    }
}
