package problem;

/**
 * problem33:丑数
 * description:把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。
 * 求按从小到大的顺序的第N个丑数。
 * Created by wtwang on 2019/5/14.
 */
public class Problem33 {
    public static void main(String[] args){
//        for(int i=1;i<=20;++i){
//            System.out.println(GetUglyNumber_Solution(i));
//        }
//        System.out.println(GetUglyNumber_Solution(7));
        System.out.println(GetUglyNumber_Solution(1500));
    }
    public static int GetUglyNumber_Solution(int index) {
        if(index <= 0){
            return 0;
        }
        int[] arr = new int[index];
        arr[0] = 1;
        int base2=0,base3=0,base5=0;
        int ug2=0,ug3=0,ug5=0;
        for(int i=1;i<index;++i){
            while(base2 < i){
                if(arr[base2]*2 > arr[i-1]){
                    ug2 = arr[base2]*2;
                    break;
                }
                base2++;
            }
            while(base3 < i) {
                if(arr[base3]*3 > arr[i-1]){
                    ug3 = arr[base3]*3;
                    break;
                }
                base3++;
            }
            while(base5 < i){
                if(arr[base5]*5 > arr[i-1]){
                    ug5 = arr[base5]*5;
                    break;
                }
                base5++;
            }
            if(ug2 <= ug3 && ug2 <= ug5){
                arr[i] = ug2;
                base2++;
            }else if(ug3 <= ug2 && ug3 <= ug5){
                arr[i] = ug3;
                base3++;
            }else if(ug5 <= ug2 && ug5 <= ug3){
                arr[i] = ug5;
                base5++;
            }
        }
        return arr[index-1];
    }

    /**
     * 之前尝试的，依次判断每个数是否是丑数
     * @param num
     * @return
     */
    public static boolean judge(int num){
        while(num%5 == 0){
            num /= 5;
        }
        while(num%3 == 0){
            num /= 3;
        }
        while(num%2 == 0){
            num /= 2;
        }
        return num == 1;
    }

    /**
     * 之前尝试的，获取下一个数，考虑不全
     * @param num
     * @return
     */
    public static int getNext(int num){
        if(num % 24 == 0){
            return num/24*25;
        }else if(num % 15 == 0){
            return num/15*16;
        }else if(num % 25 == 0){
            return num/25*27;
        }else if(num % 9 == 0){
            return num/9*10;
        }else if(num % 8 == 0){
            return num/8*9;
        }else if(num % 5 == 0){
            return num/5*6;
        }else if(num % 4 == 0){
            return num/4*5;
        }else if(num % 3 == 0){
            return num/3*4;
        }else if(num % 2 == 0){
            return num/2*3;
        }else{
            return num*2;
        }
    }

    /**
     * 之前尝试的，根据二进制规律获得下一个数，考虑不全
     */
    static class Num{
        int twos;
        int threes;
        int fives;
        public Num(){

        }
        public Num(int t1,int t2,int f){
            twos = t1;
            threes = t2;
            fives = f;
        }
        public Num getNext(){
            Num newNum = new Num();
            //020 -> 101
            if(threes >= 2){
                newNum.twos = twos + 1;
                newNum.threes = threes-2;
                newNum.fives = fives + 1;
            }
            //003 -> 020
            else if(twos >= 3){
                newNum.twos = twos - 3;
                newNum.threes = threes + 2;
                newNum.fives = fives;
            }
            //100 -> 011
            else if(fives >= 1){
                newNum.twos = twos + 1;
                newNum.threes = threes + 1;
                newNum.fives = fives - 1;
            }
            //002 -> 100
            else if(twos >= 2){
                newNum.twos = twos - 2;
                newNum.threes = threes;
                newNum.fives = fives + 1;
            }
            //010 -> 002
            else if(threes >= 1){
                newNum.twos = twos + 2;
                newNum.threes = threes - 1;
                newNum.fives = fives;
            }
            //001 -> 010
            else if(twos >= 1){
                newNum.twos = twos - 1;
                newNum.threes = threes + 1;
                newNum.fives = fives;
            }
            //000 -> 001
            else{
                newNum.twos = twos + 1;
                newNum.threes = threes;
                newNum.fives = fives;
            }
            return newNum;
        }
    }
}
