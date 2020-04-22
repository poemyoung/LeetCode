package Two11_14.LongHuiWen;

import java.util.ArrayList;

/**
 * 查找最长回文子串
 */
public class LongestHuiWen {
    /**
     * 一个内部类负责存储回文子串的起始位置
     * 其中有方法可以计算字串的长度
     */
    public class Saver{
        int start;
        int end;

        public Saver(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public int lengthCheck(){
            return end - start +1;
        }
    }
    public String longestPalindrome(String s) {
        //处理特殊情况
        //空输入
        if(s.equals("")){
            return "";
        }
        //长度为2
        if(s.length() == 2){
           if(s.charAt(0) == s.charAt(1)){
               return s;
           }else {
               return String.valueOf(s.charAt(0));
           }
        }
        //拆成数组便于查找
        char[] inp = s.toCharArray();
        int len = inp.length;
        ArrayList<Saver> palindrome = new ArrayList<>();
        //查找每个字符，找到每个可能成为回文数的字符
        for (int i = 1;i < len-1;i++){
            //奇数回文
            if(inp[i-1] == inp[i+1]){
                int st,e;
                for (st = i-1,e = i+1;st>=0&&e<=len-1;st--,e++){
                    if(inp[st]!=inp[e]){
                        break;
                    }
                }
                palindrome.add(new Saver(st+1,e-1));
            }
            //左边一样，偶数回文
            if (inp[i] == inp[i-1]){
                int st,e;
                for(st = i-1,e = i;st >=0&&e<=len-1;st--,e++){
                    if(inp[st]!=inp[e]){
                        break;
                    }
                }
                //回文数边缘
                palindrome.add(new Saver(st+1,e-1));
            }
            //右边一样，偶数回文
            if(inp[i] == inp[i+1]){
                int st,e;
                for(st = i,e = i+1;st >=0&&e<=len-1;st--,e++){
                    if(inp[st]!=inp[e]){
                        break;
                    }
                }
                palindrome.add(new Saver(st+1,e-1));
            }
        }
        //找最长回文数
        int size = palindrome.size();
        if(size == 0){
            return String.valueOf(inp[0]);
        }
        int max = palindrome.get(0).lengthCheck();
        //记录最长字串是哪个
        int position = 0;
        for (int i = 0;i < size;i++){
            if(palindrome.get(i).lengthCheck() > max){
                max = palindrome.get(i).lengthCheck();
                position = i;
            }
        }
        //包装再返回
        int start = palindrome.get(position).start;
        int end = palindrome.get(position).end;
        return String.valueOf(inp,start,end-start+1);
    }

    public static void main(String[] args) {
        LongestHuiWen test = new LongestHuiWen();
        System.out.println(test.longestPalindrome("bbbb"));
    }
}
