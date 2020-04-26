package Two11_23.KnapsackMulpTwo;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 多重背包问题2
 * 转换为01背包问题
 * 使用二进制的方法进行转换
 */
public class Knapsack {
    /**
     * 定义一个类
     * 用来保存二进制拆分后的物品
     */
    public static class Item{
        int v;
        int w;

        public Item(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) {
        //数量、容积
        int n,v;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        v = in.nextInt();
        //物品占用空间、价值、以及物品数量
        int[] c = new int[n+1];
        int[] w = new int[n+1];
        int[] num = new int[n+1];
        for (int i = 1;i <=n;i++){
            c[i] = in.nextInt();
            w[i] = in.nextInt();
            num[i] = in.nextInt();
        }
        //动态规划，类似于完全背包算法
        //使用一个数组来记录二进制位
        ArrayList<Item> arr = new ArrayList<>();
        int k;
        for (int i = 1;i <=n;i++){
           //加入二进制位
            for (k = 1;num[i] >= k;num[i]-=k,k*=2){
                arr.add(new Item(c[i] * k,w[i] * k));
            }
            if(num[i] > 0){
                arr.add(new Item(c[i] * num[i],w[i] * num[i]));
            }
        }
        //现在arr中为实际物品数，对arr采用01背包的方式进行计算
        int size = arr.size();
        int[] f = new int[v+1];
        for (int i = 0;i <=size-1;i++){
            for (int j = v;j >=arr.get(i).v;j--){
                f[j] = Math.max(f[j],f[j-arr.get(i).v]+arr.get(i).w);
            }
        }
        System.out.println(f[v]);
    }
}

