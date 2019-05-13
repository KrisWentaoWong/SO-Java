package problem;

/**
 * problem10:
 * description:我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * Created by wtwang on 2019/5/12.
 */
public class Problem10 {
    public static void main(String[] args){
        System.out.println(RectCover(3));
    }

    public static int RectCover(int target) {
        if(target == 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        int[] dp = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=target;++i){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }
}
