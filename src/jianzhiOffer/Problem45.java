package jianzhiOffer;

/**
 * problem45:扑克牌的顺子
 * description:LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何,如果牌能组成顺子就输出true,否则就输出false。
 * 为了方便起见,你可以认为大小王是0。
 * Created by wtwang on 2019/5/15.
 */
public class Problem45 {
    public static void main(String[] args){
        int[] numbers = {1,3,0,0,5};
        System.out.println(isContinuous(numbers));
    }

    public static boolean isContinuous(int [] numbers) {
        if(numbers.length < 5){
            return false;
        }
        int[] index = new int[14];
        for(int i=0;i<numbers.length;++i){
            index[numbers[i]]++;
        }
        int start = -1;
        int vacant = 0;
        for(int i=1;i<index.length;++i){
            //有个数出现了两次
            if(index[i] > 1){
                return false;
            }
            //最小的数字记录，记录开始位置
            else if(index[i] == 1 && start == -1){
                start = i;
            }
            //在start到start+4之间空缺的个数，可以通过0来补充
            else if(index[i] == 0 && start != -1 && i-start <= 4){
                vacant++;
            }
        }
        //判断空缺的个数和0的个数是否相等
        if(vacant == index[0]){
            return true;
        }else{
            return false;
        }
    }
}
