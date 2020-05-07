package Three24_30.LongestCommonPre;

/**
 * 最长公共前缀
 */
public class LongestPrefix {
    public String longestCommonPrefix(String[] strs) {
        //特殊情况
        if(strs.length == 0){
            return "";
        }
        StringBuilder res = new StringBuilder();
        //找到最短字符串
        int min = strs[0].length();
        for (String a : strs){
            if(a.length()< min){
                min = a.length();
            }
        }
        //循环匹配前缀
        //匹配标志，为真表示仍然可以匹配
        boolean flag = true;
        for (int i = 0;i < min;i++){
            char match = strs[0].charAt(i);
            for (String b : strs){
                if(!(b.charAt(i) == match)){
                   flag = false;
                   break;
                }
            }
            if(flag){
                res.append(match);
            }
        }
        return res.toString();
    }
}
