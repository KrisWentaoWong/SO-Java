package problem;

/**problem7:跳台阶
 * description:一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * Created by kriswong on 2019/5/12.
 */
public class Problem8 {
    public int JumpFloor(int target) {
        if(target <= 1){
            return 1;
        }
        int[] dp = new int[target+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=target;++i){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }
}
