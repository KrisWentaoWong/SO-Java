package jianzhiOffer;

/**
 * problem1:二维数组的查找
 * description:在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * Created by wtwang on 2019/5/10.
 */
public class Problem1 {
    /**
     * 初始位置设为数组的左下角或者右上角
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {
        int r = array.length;
        if(r <= 0){
            return false;
        }
        int c = array[0].length;
        if(c <= 0){
            return false;
        }
        int i=r-1,j=0;
        while(i>=0 && j< c){
            if(array[i][j] < target){
                j++;
            }else if(array[i][j] > target){
                i--;
            }else{
                return true;
            }
        }
        return false;
    }
}
