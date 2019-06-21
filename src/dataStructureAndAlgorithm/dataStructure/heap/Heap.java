package dataStructureAndAlgorithm.dataStructure.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型最小堆，满足父节点元素都比子节点元素小
 * Created by wtwang on 2019/6/21.
 */
public class Heap<E extends Comparable>{
    public static void main(String[] args) {
        Integer[] arr = new Integer[7];
        arr[0] = 4;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 5;
        arr[4] = 3;
        arr[5] = 7;
        arr[6] = 6;
        Heap<Integer> hp = new Heap<>(arr);
        int size = hp.getSize();
        for (int i = 0; i < size; ++i) {
            System.out.print(hp.remove() + " ");
        }
    }

    private List<E> list = new ArrayList<E>();
    public Heap(E[] arr){
        for(int i=0;i<arr.length;++i){
            put(arr[i]);
        }
    }

    public void put(E num){
        //将元素加入到数组中
        list.add(num);
        //因为在插入之前已经是最小堆，所以调整最小堆只需要调整新插入的元素到合适的位置
        int index = getSize()-1;
        while(index > 0){
            int parent = (index-1) >> 1;
            //如果父节点的值比待插入的值小，跳出循环
            if(list.get(parent).compareTo(num) < 0){
                break;
            }
            //将子节点的值设置为父节点的值，即将父节点的值拷贝到子节点
            list.set(index,list.get(parent));
            //子节点的下标指向父节点的下标，继续判断
            index = parent;
        }
        //原先在index处的值已经拷贝到子节点中，所以index即为待插入节点的位置
        list.set(index,num);
    }

    public E remove(){
        if(getSize() <= 0){
            return null;
        }
        //获取根结点
        E num = list.get(0);
        E last = list.get(getSize()-1);
        //取最后一个元素，放到根结点的位置
        list.set(0,last);
        //删除最后一个元素
        list.remove(getSize()-1);
        //调整剩下的元素为最小堆
        int index = 0;
        while((index<<1)+1 < getSize()){
            //将obj默认设置为左子节点
            int next = (index<<1)+1;
            E obj = list.get((index<<1)+1);
            //有右子节点且右子节点比左子节点小，则将右子节点更新为obj，即obj为左右子节点的较小值
            if((index<<1)+2 < getSize() && list.get((index<<1)+2).compareTo(obj)<0){
                obj = list.get((index<<1)+2);
                next = next+1;
            }
            //如果当前节点小于obj，则退出循环
            if(list.get(index).compareTo(obj)<0){
                break;
            }
            //否则将交换待当前节点和下一个节点
            list.set(index,obj);
            index = next;
            list.set(index,last);
        }
        return num;
    }

    public int getSize(){
        return list.size();
    }
}
