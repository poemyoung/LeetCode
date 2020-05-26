package Four31_40.MajorElement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 多数元素
 */
public class MajorElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> recorder = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            Integer tmp = recorder.get(nums[i]);
            if(tmp == null){
                //第一次插入该数字
                recorder.put(nums[i],1);
            }else {
                //已经插入
                recorder.replace(nums[i],tmp+1);
            }
        }
        //查找大于n / 2个数的所有数
        Set<Integer> aSet = recorder.keySet();
        int halfN = nums.length / 2;
        Iterator<Integer> it = aSet.iterator();
        while (it.hasNext()){
            int tmp2 = it.next();
            if(recorder.get(tmp2) > halfN){
                return tmp2;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MajorElement test = new MajorElement();
        int[] a = {3,2,3};
        System.out.println(test.majorityElement(a));
    }
}
