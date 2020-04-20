package One1_10.FindBinary1OfInteger;

public class Find {
    /**
     * 找1
     */
    public static int find(int n){
        //基准条件
        if(n == 1){
            return 1;
        }
        //递归条件
        //当前方法只做当前方法要做的事
        if(n % 2 == 1) {
            //如果为1，则返回值加一
            return find(n / 2)+1;
        }else {
            //否则返回值不变
            return find(n / 2);
        }
    }
    /**
     * 测试方法
     */
    public static void main(String[] args) {
       System.out.println(Find.find(512));
    }
}
