package MaxProfit;

import java.util.ArrayList;

/**
 * 计算最大利润
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        //特殊情况
        if(len == 0){
            return 0;
        }
        //最小指针
        int min = prices[0];
        //最大指针;
        int max = prices[0];
        //记录数组
        ArrayList<Integer> recorder = new ArrayList<>();
        //移动记录寻找
        for (int i = 0;i < len;i++){
            //最小指针移动
            if(prices[i] < min && i < len-1){
                recorder.add(max - min);
                min = prices[i];
                max = min;
            }else if(prices[i] > max){
                max = prices[i];
            }
            if(i == len-1){
                //结束时收回max和min
                recorder.add(max - min);
            }
        }
        //找到数组最大值
        int res = 0;
        int arrLen = recorder.size();
        for (int i = 0;i < arrLen;i++){
            if(recorder.get(i) > res){
                res = recorder.get(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxProfit test =  new MaxProfit();
        int[] a ={7,6,4,3,1};
        System.out.println(test.maxProfit(a));
    }
}
