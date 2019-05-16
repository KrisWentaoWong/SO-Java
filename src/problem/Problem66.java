package problem;

/**
 * problem66:机器人的运动范围
 * description:地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * Created by wtwang on 2019/5/16.
 */
public class Problem66 {
    public static void main(String[] args){
        System.out.println(movingCount(-10,10,10));
    }
    public static int movingCount(int threshold, int rows, int cols) {
        if(rows == 0 || cols == 0){
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        for(int i=0;i<rows;++i){
            for(int j=0;j<cols;++j){
                if(i == 0 && j == 0 && threshold >= 0){
                    visited[i][j] = true;
                    count++;
                }
                //visited数组作用是为了保证满足条件的位置一定可以到达，即存在一个可达联通路线
                if(getSum(i)+getSum(j) <= threshold &&
                        (i-1>=0 && visited[i-1][j] || i+1<rows && visited[i+1][j]
                                || j-1>=0 && visited[i][j-1] || j+1<cols && visited[i][j+1])){
                    visited[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static int getSum(int x){
        int count = 0;
        while(x>0){
            count += x%10;
            x /= 10;
        }
        return count;
    }
}
