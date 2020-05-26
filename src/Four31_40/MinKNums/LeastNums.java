package Four31_40.MinKNums;

import java.util.Arrays;

/**
 * 建立一个k个数的最大堆，然后往堆中一直插入元素
 * 大于最大元素的不要
 * 否则从头往下滤
 */
public class LeastNums {
    public int[] getLeastNumbers(int[] arr, int k) {
        //特殊情况
        if(k == 0){
            return new int[0];
        }
        //堆中元素
        int[] heap = new int[k+1];
        //用前k个元素新建一个堆
        for (int i = 0;i < k;i++){
            heap[i+1] = arr[i];
        }
        for (int i = (heap.length-1)/2;i >=1;i--){
            percolateDown(i,heap);
        }
        //插入并下滤
        for (int i = k;i < arr.length;i++){
            if(arr[i] >= heap[1]){
                //大于堆顶元素，不要
            }else {
                heap[1] = arr[i];
                percolateDown(1,heap);
            }
        }
        return Arrays.copyOfRange(heap,1,heap.length);
    }
    private void percolateDown(int i,int[] array){
        //对于堆中元素从位置i开始下滤
        int tmp = array[i];
        int hole = i;
        int child;
        for (;hole * 2 <= array.length-1;hole = child){
            //先赋值比较两个孩子的大小
            child = hole * 2;
            //判断往左边滤还是右边滤
            if(child < array.length-1 && array[child+1] > array[child]){
                child++;
            }
            //判断是否要继续滤
            if(tmp < array[child]){
                array[hole] = array[child];
            }else {
                break;
            }
        }
        array[hole] = tmp;
    }

    public static void main(String[] args) {
        LeastNums test = new LeastNums();
        int[] a = {0,0,1,2,4,2,2,3,1,4};
        test.getLeastNumbers(a,8);
        System.out.println(Arrays.toString(test.getLeastNumbers(a, 8)));
    }
}
