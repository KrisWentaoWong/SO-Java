package problem;

/**problem9:变态跳台阶
 * description:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * Created by kriswong on 2019/5/12.
 */
public class Problem9 {
    public static void main(String[] args){
        System.out.println(JumpFloorII(2));
    }
    public static int JumpFloorII(int target) {
        if(target <= 1){
            return 1;
        }
        int[] dp = new int[target+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=target;++i){
            //对于终点为i的每一种跳法，如果跳1步，则剩余i-1步；如果跳j步，则剩余i-j步。
            //因为可以跳的步数为1到i，则需遍历j。
            //dp[0]定义为1，对应于跳i步的情况
            for(int j=1;j<=i;++j){
                dp[i] += dp[i-j];
            }
        }
        return dp[target];
    }
}
