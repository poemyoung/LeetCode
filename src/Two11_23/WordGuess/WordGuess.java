package Two11_23.WordGuess;

public class WordGuess {
    //待查单词表
    char[][] wordTable;
    //待查单词
    String[] words;
    //单词表长和宽
    int len;
    /**
     * 构造函数，传入参数
     */
    public WordGuess(char[][] wordTable,String...words){
        this.wordTable = wordTable;
        this.words = words;
        this.len = wordTable[0].length;
    }
    /**
     * 处理函数
     */
    public void deal(){
        //测试每一个单词，判断是不是

    }
    /**
     * 传四个参数，行号，列号，方向，字符串个数
     */
    public void findCircle(){
        //拼成字符串
        StringBuilder old = new StringBuilder();
        //左右方向一起走
        for (int i = 0;i < len;i++){
            //way有0,1,2,3四种
            //左
            find(wordTable[i],3,i);
            //右
            char[] right = new char[len];
            for(int j = len-1;j>=0;j--){
                right[len-j-1] = wordTable[i][j];
            }
            //调用
            find(right,1,i);
        }
        //上下方向一起走
        for (int i = 0;i<len;i++){
            //上
            char[] up = new char[len];
            for (int j = 0;j < len;j++){
                up[j] = wordTable[j][i];
            }
            find(up,0,i);
            //下
            char[] down = new char[len];
            for (int j = len - 1;j >= 0;j--){
                down[len-1-j] = wordTable[j][i];
            }
            find(down,2,i);
        }
        //对角线
        char[] upRight = new char[len];
        char[] upLeft = new char[len];
        char[] downRight = new char[len];
        char[] downLeft = new char[len];
        //赋值并调用
        for(int k = 0;k < len;k++){
            upRight[k] = wordTable[k][len - k -1];
            upLeft[k] = wordTable[k][k];
            downLeft[k] = wordTable[len-1-k][k];
            downRight[k] = wordTable[len - 1 - k][len - 1 - k];
        }
        //调用
        find(upRight,4,0);
        find(upLeft,4,0);
        find(downRight,5,0);
        find(downLeft,5,0);
    }

    /**
     * 执行一串字符中找子串
     * 模拟contains函数
     * @param way 0,1,2,3,4,5 上右下左，（上左，下左），（下右，上右）
     */
    public void find(char[] toFind,int way,int tag){
        //真实的坐标是从1开始
        tag++;
        //外层循环，标注起始位置
        //记录真实坐标，i，j
        for (int i = 1;i <= toFind.length;i++){
            //内层循环，标注结束位置
            for (int j = i;j <= toFind.length;j++){
                StringBuilder newString = new StringBuilder();
                for(int k= i-1;k < j;k++) {
                    newString.append(toFind[k]);
                }

                //判相等
                for (int k = 0;k < words.length;k++){
                    if(words[k].equals(newString.toString())){
                       switch (way){
                           case 0:
                               System.out.println(newString+": "+"("+i+","+tag+")"+" to "+"("+j+","+tag+")");
                               break;
                           case 1:
                               System.out.println(newString+": "+"("+tag+","+j+")"+" to "+"("+tag+","+i+")");
                               break;
                           case 2:
                               System.out.println(newString+": "+"("+j+","+tag+")"+" to "+"("+i+","+tag+")");
                               break;
                           case 3:
                               System.out.println(newString+": "+"("+tag+","+i+")"+" to "+"("+tag+","+j+")");
                               break;
                           case 4:
                               System.out.println(newString+": "+"("+j+","+j+")"+" to "+"("+i+","+i+")");
                               break;
                           case 5:
                               System.out.println(newString+": "+"("+i+","+i+")"+" to "+"("+j+","+j+")");
                               break;
                           default:
                               System.out.println("???");
                       }
                    }
                }
            }
        }
    }
    /**
     * 测试
     */
    public static void main(String[] args) {
        char[][] test = {{'t','h','i','s'},{'w','a','t','s'},{'o','a','h','g'},{'f','g','d','t'}};
        String[] testWords = {"this", "two", "fat", "that","his"};
        WordGuess tes = new WordGuess(test,testWords);
        tes.findCircle();
    }
}
