package MinKNums;

import java.util.Arrays;

/**
 * 使用快排方法
 */
public class QuickSelect {
    public int[] getLeastNumbers(int[] arr, int k) {
        //特殊情况
        if (k == 0) {
            return new int[0];
        }else if(k == arr.length){
            return arr;
        }
        //将数组最小的k个数划分出来
        partitionArray(arr,0,arr.length-1,k);
        return Arrays.copyOfRange(arr,0,k);
    }

    /**
     *找到最小的k个数递归算法
     */
    private void partitionArray(int[] arr,int lo,int hi,int k){
        //找到任意划分数的数组下标
        int res = partition(arr,lo,hi);
        //第一，下标减lo刚好等于k，什么都不做
        if(res == k){

        }else if(res < k){
            //下标减lo小于k
            //下标及左边的数共res个全部都要加入数组(即不再变化）
            //下标右边还需要找出最小的 k - res个数
            partitionArray(arr,res + 1,hi,k);
        }else {
            //下标减lo大于k
            //下标左边需要找出最小的k个数
            partitionArray(arr,lo,res - 1,k);
        }
    }

    /**
     * 选择划分算法
     */
    int partition(int[] a,int lo,int hi){
        int tmp = a[lo];
        int i = lo;
        int j = hi + 1;
        //循环交换
        while (i < j){
            //找到比tmp大的i
            //位置lo一定小于等于lo，不需要再判断一次
            while (a[++i] < tmp && i != hi);
            //找到比tmp小的j
            //j不走出界，最多智能走到lo
            while (a[--j] > tmp && j != lo);
            //判断i和j的位置以确定要不要交换
            if(i < j){
               int t = a[i];
               a[i] = a[j];
               a[j] = t;
            }
        }
        int w = a[j];
        a[j] = a[lo];
        a[lo] = w;
        //i或者j其中到终点的数不要
        //只有两种情况：i比j大一或者i等于j
        return j;
    }

    public static void main(String[] args) {
        QuickSelect test = new QuickSelect();
        int[] a = {0,0,2,3,2,1,1,2,0,4};
        test.getLeastNumbers(a,10);
        System.out.println(Arrays.toString(test.getLeastNumbers(a, 8)));
    }
}
