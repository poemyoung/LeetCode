package PrintInt;

public class PrintInt {
    /**
     * 打印递归函数
     */
    public static void printOut(int n){
        //基准条件,n小于10时直接打印出
        if(n > 0&&n <10){
            System.out.println(n);
            return;
        }
        //递归不打印
        printOut(n/10);
        //递归返回后打印，按顺序输出
        System.out.println(n%10);

    }
    /**
     * 测试
     */
    public static void main(String[] args) {
        PrintInt.printOut(123233435);
    }
}
