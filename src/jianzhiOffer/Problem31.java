package jianzhiOffer;

/**
 * problem31:整数中1出现的次数
 * description:求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
 * Created by wtwang on 2019/5/14.
 */
public class Problem31 {
    /**
     * 依次判断每个数中1的个数
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0){
            return 0;
        }
        //count表示1出现的次数，base表示当前位，round表示当前包括当前位的数
        int count = 0,base = 1,round = n;
        while(round > 0){
            //weight表示当前位的值
            int weight = round%10;
            //此时round更新为当前位高位的数，可以理解为系数
            round /= 10;
            //当前位1出现的次数=高位*base
            count += round * base;
            //如果当前位等于1，则需要加上低位，当base为1时，n%base==0
            if(weight == 1){
                count += (n%base)+1;
            }else if(weight > 1){
                count += base;
            }
            base *= 10;
        }
        return count;
    }

}
