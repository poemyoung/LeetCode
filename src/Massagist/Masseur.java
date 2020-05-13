package Massagist;

import java.util.Arrays;

/**
 * 按摩师问题,动态规划
 */
public class Masseur {
    public int massage(int[] nums) {
      //特殊情况
        if(nums.length == 0){
            return 0;
        }
        //开辟动态规划数组
        int[] dp = new int[nums.length+10];
        //从右往左遍历
        for (int i = nums.length-1;i >= 0;i--){
            //选当前数和不选当前数
            //不选当前数就和前一个数相等
            dp[i] = Math.max(nums[i]+dp[i+2],dp[i+1]);
        }
        //找最大值
        int max = dp[0];
        for (int i = 0;i < dp.length;i++){
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[]a = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        Masseur test = new Masseur();
        int res = test.massage(a);
        System.out.println(res);
    }
}
