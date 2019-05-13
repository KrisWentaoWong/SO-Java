package problem;

/**
 * problem5:旋转数组中的最小数字
 * description:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * Created by wtwang on 2019/5/10.
 */
public class Problem6 {
    public static void main(String[] args){
        //在数组中不包含重复数字和包含重复数字时的解法不同
        //包含重复数字时可能无法直接一步判断确定子区间，需要查找两个子区间返回较小值，如下面这个例子
        int[] array = {10,1,10,10,10};
        System.out.println(minNumberInRotateArray(array));
    }

    public static int minNumberInRotateArray(int [] array) {
        //如果数组大小为0，则返回0
        if(array.length <= 0){
            return 0;
        }
        return help(array,0,array.length-1);
    }

    public static int help(int[] array,int low,int high){
        //二分查找寻找转折点
        int mid = (high - low) / 2 + low;
        while(mid > low){
            //如果第一个元素比最后一个元素小，则说明已经有序，直接返回第一个元素
            if(array[low] < array[high]){
                return array[low];
            }
            //在第一个元素比最后一个元素大或相等的情况下
            //如果中间元素比最后一个元素大，则转折点在后半部分
            else if(array[mid] > array[high]){
                low = mid + 1;
            }
            //如果中间元素比最后一个元素小，则转折点在前半部分
            else if(array[mid] < array[high]){
                high = mid;
            }
            //如果中间元素和最后一个元素相等，则既可能在前半部分也可能在后半部分，返回两部分的较小值
            else{
                return Math.min(help(array,low,mid),help(array,mid+1,high));
            }
            mid = (high - low) / 2 + low;
        }
        if(array[low] <= array[high]){
            return array[low];
        }else{
            return array[high];
        }
    }
}
