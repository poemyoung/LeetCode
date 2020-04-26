package Two11_23.KnapsackMulpOne;

import java.util.Scanner;

/**
 * 多重背包问题
 */
public class Knapsack {
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
        int[] f = new int[v+1];
        for (int i = 1;i <=n;i++){
            for (int j = v;j >=c[i];j--){
                for (int k = 1;k <= num[i];k++) {
                    if(j-k*c[i]>=0) {
                        f[j] = Math.max(f[j], f[j - k * c[i]] + k * w[i]);
                    }
                }
            }
        }
        System.out.println(f[v]);
    }
}
