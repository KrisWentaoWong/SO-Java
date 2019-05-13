package problem;

import java.util.ArrayList;

/**
 * problem19:顺时针打印矩阵
 * description:输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * Created by wtwang on 2019/5/13.
 */
public class Problem19 {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(matrix);
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        //设置方向，分别对于向右、向下、向左、向上
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        int r = matrix.length;
        if(r == 0){
            return list;
        }
        int c = matrix[0].length;
        //访问数组，记录点是否已经被访问过
        boolean[][] visited = new boolean[r][c];
        int i=0,j=0;
        //记录当前已访问点的个数
        int count = 0;
        //表示当前方向数组的下标
        int d = 0;
        while(count < r*c){
            if(visited[i][j] == false) {
                visited[i][j] = true;
                list.add(matrix[i][j]);
                count++;
            }
            //如果当前方向可以继续，则继续当前方向。否则换下一个方向
            if(i+direction[d][0] >=0 && i+direction[d][0] < r &&
                    j+direction[d][1] >=0 && j+direction[d][1] < c &&
                    !visited[i+direction[d][0]][j+direction[d][1]]){
                i += direction[d][0];
                j += direction[d][1];
            }else{
                d = (d+1)%direction.length;
            }
        }
        return list;
    }
}
