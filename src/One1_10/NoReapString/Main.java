package One1_10.NoReapString;

import java.util.Scanner;

public class Main {
    /**
     * @param s
     * 主要实现逻辑的方法
     */
    public int lengthOfLongestSubstring(String s) {
        //记住考虑空字符串的情况
        if(s.equals("")){
            return 0;
        }
        //将输入转为一个char数组
        char[] input = s.toCharArray();
        //维护一个字符队列
        //长度为n
        int n = input.length;
        //最大值，输出结果
        int res = 1;
        //队列起始指针
        int start = 0;
        //队列结尾指针
        int end = 0;
        //临时计算队列长度
        int temp = 0;
        //一个一个(插入)字符，每插入一个字符之前进行一次扫描，确保没有重复字符
        for(int i = 0;i < n;i++){
            //队列头到末尾，退出循环
            if(end == n-1){
                //队列头和队列尾在一起，表明队列中有一个元素，故+1
                temp = end-start+1;
                if(temp > res){
                    res = temp;
                }
                break;
            }
            //扫描end的下一个字符是否与队列中元素重复
            boolean flag = false;
            //临时记录哪个值重复
            int record = start;
            for(int j = start;j<=end;j++){
                if(input[j] == input[end+1]){
                    flag = true;
                    //j序号的值重复
                    record = j;
                }
            }
            //若发现重复，队列起始指针移位
            if(flag){
                temp = end - start +1;
                if(temp > res){
                    res = temp;
                }
                start = record + 1;
            }
            //队列加入数据
            end++;
        }
        return  res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inp = in.nextLine();
        Main test = new Main();
        System.out.println(test.lengthOfLongestSubstring(inp));
    }
}
