package ShowAllArrangements;

import java.util.Arrays;

public class Permute {
   public int count;

    /**
     * 驱动程序
     */
    public void permute(String str){
        char[] strChar = str.toCharArray();
        permute(strChar,0,strChar.length - 1);
    }
    /**
     * 递归程序
     * @param str 待打印数组
     * @param low 待交换元素下标
     * @param high 数组最后元素下标
     */
    public void permute(char[] str,int low,int high){
        //基准条件
        //递归到叶子节点，即待交换元素为最后一个元素
        if(low == str.length - 1){
            System.out.println(str);
            count++;
            return;
        }
        //中间循环交换节点，但是不做任何输出处理
        for(int i = low;i <= high;i++){
            //交换
            char temp = str[low];
            str[low] = str[i];
            str[i] = temp;
            //递归处理
            permute(str,low+1,high);
            //递归处理完毕再换回来
            char temp2 = str[low];
            str[low] = str[i];
            str[i] = temp2;
        }
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        Permute test = new Permute();
        test.permute("abcd");
        System.out.println(test.count);
    }
}
