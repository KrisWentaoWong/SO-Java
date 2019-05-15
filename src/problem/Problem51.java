package problem;

/**
 * problem51:构建乘积数组
 * description:给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * Created by wtwang on 2019/5/15.
 */
public class Problem51 {
    /**
     * n^2复杂度的解法，丑陋
     * @param A
     * @return
     */
//    public int[] multiply(int[] A) {
//        int[] B = new int[A.length];
//        for(int i=0;i<B.length;++i){
//            int num = 1;
//            for(int j=0;j<A.length;++j){
//                if(j != i){
//                    num *= A[j];
//                }
//            }
//            B[i] = num;
//        }
//        return B;
//    }

    /**
     * 将A和B画成一个二维矩阵，第i列的值为A[i]，则第j行的乘积为B[j]，且主对角线上的值均为1
     * 那么主对角线将矩阵分为上三角和下三角
     * 每个三角之间的B[i]均有递推关系，将两部分计算得到的值乘起来即可。
     * 时间复杂度为n
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int[] C = new int[A.length];
        for(int i=0;i<B.length;++i){
            B[i] = 1;
            C[i] = 1;
        }
        //B[i]为下三角矩阵中每一行的乘积
        for(int i=1;i<A.length;++i){
            B[i] = A[i-1] * B[i-1];
        }
        //C[i]为上三角矩阵中每一行的乘积
        for(int j=A.length-2;j>=0;j--){
            C[j] = A[j+1] * C[j+1];
        }
        for(int i=0;i<A.length;++i){
            B[i] *= C[i];
        }
        return B;
    }
}
