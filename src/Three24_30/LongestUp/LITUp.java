package Three24_30.LongestUp;

/**
 *  最长上升子序列
 */
public class LITUp {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        //特殊情况
        if(len <= 1){
            return len == 1?1:0;
        }
        int maxRes = 0;
        //反向查找并记录每一个的最优解,动态规划
        int[] recorder = new int[len];
        for (int i = len - 1;i >= 0;i--){
                //内层循环寻找大于该值且   最大值的值
            int max = 0;
            for (int j = i;j < len;j++){
                if(nums[j] > nums[i] && recorder[j] > max){
                    max = recorder[j];
                }
            }
            recorder[i] += max + 1;
        }
        //找到最大值
        int m = 0;
        for (int num : recorder){
            if(num > m){
                m = num;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        LITUp test = new LITUp();
        int[] a = {10,9,2,5,3,4};
        System.out.println(test.lengthOfLIS(a));
    }
}
