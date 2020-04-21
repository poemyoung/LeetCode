import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        //处理输入
        Scanner in =  new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        //处理特殊情况，够分
        if(m % n == 0){
            System.out.println(0);
            return;
        }
        //处理一般情况
        //第一种情况，m < n，只需要执行其中的一种方法即可
        if(a > b){
            //买礼物
            System.out.println((n-m) * b);
            return;
        }else {
            //发红包
            System.out.println((n-m) * a);
            return;
        }
        //第二种情况,m > n，此时可能存在两种方法一起执行的情况


    }

}