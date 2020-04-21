package FAIL_LIST.NumberSubArrays;

import java.util.ArrayList;

/**
 * 记录奇数数组下标就ok了
 * 数组的边界为-1和len!!!
 */
public class NumSubArrays {
    public int numberOfSubarrays(int[] nums, int k){
        int res = 0;
        int len = nums.length;
        //扫描，并记录所有的奇数下标，放入数组，在这里用arrayList
        ArrayList<Integer> recorder = new ArrayList<>(len+2);
        //把0加在开头
        recorder.add(-1);
        //记录奇数下标
        for (int i = 0;i < len;i++){
            if(nums[i] % 2==1){
                recorder.add(i);
            }
        }
        //把边界加在结尾
        recorder.add(len);
        //循环（滑动窗口）计算结果
        int size = recorder.size();
        //从1开始，因为0是边界,size-1也是边界
        for (int s = 1,e = s+k-1;e < size-1;s++,e++){
            res += (recorder.get(s)-recorder.get(s-1))*(recorder.get(e+1)-recorder.get(e));
        }
        return res;

    }

    public static void main(String[] args) {
        int[] a1 = {1,1,2,1,1};
        int k1 = 3;
        NumSubArrays test = new NumSubArrays();
        System.out.println(test.numberOfSubarrays(a1,k1));
    }

}
