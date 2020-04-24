package FAIL_LIST.FourSum;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //排序,选择排序
        int len = nums.length;
        for (int i = 0;i < len;i++){
            for (int j = i;j < len;j++){
                if(nums[j] < nums[i]){
                    //交换
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        //结果集
        List<Integer> resInside = new ArrayList<>();
        HashSet<List<Integer>> res = new HashSet<>();
        //固定前两个指针
        int a = 0,b = 0;
        //移动后两个指针
        int c = 0,d = 0;
        for ( a = 0;a < len-3;a++){
            for (b = a+1;b<len-2;b++){
                int abSum = nums[a] + nums[b];
                c = b+1;
                d = len-1;
                while (c < d){
                    if((abSum + nums[c] + nums[d]) >target){
                        d--;
                    }else if(abSum + nums[c] + nums[d] < target){
                        c++;
                    }else {
                        resInside.add(nums[a]);
                        resInside.add(nums[b]);
                        resInside.add(nums[c]);
                        resInside.add(nums[d]);
                        res.add(resInside);
                        resInside = new ArrayList<>();
                        c++;
                        d--;
                    }
                }
            }
        }
        ArrayList<List<Integer>> result = new ArrayList<>(res);
        return result;

    }

    public static void main(String[] args) {
        FourSum test = new FourSum();
        int[] a = {0,0,0,0};
        System.out.println(test.fourSum(a,0));
    }
}
