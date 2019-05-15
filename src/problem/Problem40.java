package problem;

/**
 * problem40:数组中只出现一次的数
 * description:一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * Created by wtwang on 2019/5/15.
 */
public class Problem40 {
    public static void main(String[] args){
        int[] nums = {2,4,3,6,3,2,5,5};
        FindNumsAppearOnce(nums,new int[1],new int[1]);
    }
    public static void FindNumsAppearOnce(int [] nums,int[] nums1,int[] nums2) {
        //设数组中只出现一次的数字为a和b，则xor的结果为a^b
        int xor = 0;
        for(int i=0;i<nums.length;++i){
            xor ^= nums[i];
        }
        //bit为xor中为1的最低位
        int bit = 1;
        while((xor & bit) == 0){
            bit = bit << 1;
        }
        //因为a和b必然在bit位不同，所以可以通过bit将原数组分为两个部分
        for(int i=0;i<nums.length;++i){
            //在bit位为0
            if((bit & nums[i]) == 0){
                nums1[0] ^= nums[i];
            }
            //在bit位为1
            else{
                nums2[0] ^= nums[i];
            }
        }
        System.out.println(nums1[0]);
        System.out.println(nums2[0]);
    }
}
