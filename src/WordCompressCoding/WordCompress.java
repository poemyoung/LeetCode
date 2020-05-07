package WordCompressCoding;

import java.util.ArrayList;

/**
 * 单词压缩编码
 */
public class WordCompress {
    public int minimumLengthEncoding(String[] words) {
        if (words.length == 0){
            return 0;
        }
        //将数组排序，从长到短
        //利用字符串长度在=<7之间这个事实
        //第一遍，找到整个数组字符串最大长度和最小长度
        int max = words[0].length();
        int min = max;
        for (int i = 0;i < words.length;i++){
            if(words[i].length() > max){
                max = words[i].length();
            }
            if(words[i].length() < min){
                min = words[i].length();
            }
        }
        //第max - min遍，排序
        ArrayList<String> sortStr = new ArrayList<>(words.length);
        for (int n = max;n >= min;n--){
            for (int j = 0;j < words.length;j++){
                if(words[j].length() == n){
                    sortStr.add(words[j]);
                }
            }
        }
        StringBuilder compress =  new StringBuilder();
        //循环检查
        for (int i = 0;i < words.length;i++){
            if(compress.toString().contains(sortStr.get(i)+"#")){
                continue;
            }else {
                compress.append(sortStr.get(i)+"#");
            }
        }
        return compress.toString().length();
    }

    public static void main(String[] args) {
        WordCompress test = new WordCompress();
        String[] a = {"me","time"};
        int res = test.minimumLengthEncoding(a);
       System.out.println(res);
    }
}
