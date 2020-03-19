package TwoSum;

public class SumTwo {
    public static void main(String[] args) {
        SumTwo a = new SumTwo();
        int[] c = {2, 7, 11, 15};
        int[] b = a.twoSum(c,9);
        System.out.println(b[0]+" "+b[1]);
    }
    public int[] twoSum(int[] nums, int target) {
       int n = nums.length;
       int res[] = new int[2];
        for(int i = 0;i < n-1;i++){
            for (int j = i+1;j < n;j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}
