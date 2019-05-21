package leetcode;

import java.util.PriorityQueue;

/**
 * Created by wtwang on 2019/5/21.
 */
public class SuperUglyNumber_313 {
    public static void main(String[] args){
        int n = 12;
        int[] primes = {2,7,13,19};
        for(int i=1;i<=n;++i) {
            System.out.println(nthSuperUglyNumber(i, primes));
        }
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        //题目中给定0 < k ≤ 100
        int k = primes.length;
        //index表示primes数组中各个元素对应的倍数
        int[] index = new int[k];
        //prime数组中prime[i]表示第i个满足条件的数，prime[0]=1
        int[] prime = new int[n];
        prime[0] = 1;
        for(int i=1;i<n;){
            //建立最小堆，求出k个元素中最小的作为下一个prime数
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int j=0;j<k;++j){
                pq.offer(prime[index[j]] * primes[j]);
            }
            //找出获得最小值的那个素数维度进行更新
            int num = pq.peek();
            for(int j=0;j<k;++j){
                if(num == prime[index[j]] * primes[j]){
                    index[j]++;
                    break;
                }
            }
            //过滤重复的元素
            if(num > prime[i-1]) {
                prime[i] = num;
                ++i;
            }
        }
        return prime[n-1];
    }
}
