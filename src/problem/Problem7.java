package problem;

/**
 * problem7:斐波那契数列
 * description:要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * Created by wtwang on 2019/5/12.
 */
public class Problem7 {
    public int Fibonacci(int n) {
        if(n <= 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        int first = 0;
        int second = 1;
        int res = 0;
        for(int i=2;i<=n;++i){
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }
}
