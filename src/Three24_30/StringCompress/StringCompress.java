package Three24_30.StringCompress;

/**
 * 字符串压缩算法
 */
public class StringCompress {
    public String compressString(String S) {
        //记录字符串长度
        int len = S.length();
        //特殊情况
        if(len == 0){
            return S;
        }
        //一般情况
        //记录结果
        StringBuilder res = new StringBuilder();
        //记录连续字符串的长度
        int tmpLen = 0;
        char tmpChar = S.charAt(0);
        for (int i = 0;i < len;i++){
            if(tmpChar == S.charAt(i)){
                tmpLen++;
            }else {
                //写入并更新
                res.append(String.valueOf(tmpChar)+tmpLen);
                tmpChar = S.charAt(i);
                tmpLen = 1;
            }
        }
        //把末尾剩下的加上去
        res.append(String.valueOf(tmpChar)+tmpLen);
        return res.length() >= len? S: res.toString();
    }

    public static void main(String[] args) {
        StringCompress test = new StringCompress();
        System.out.println(test.compressString("aabcccccaaa"));
    }
}
