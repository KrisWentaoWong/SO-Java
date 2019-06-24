package leetcode;

/**
 * Created by wtwang on 2019/6/24.
 */
public class NumberOfDigitOne_233 {
    public int countDigitOne(int n) {
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
