package Two11_23.KnapsackTotal;

import java.util.Scanner;

/**
 * 完全背包问题，已优化版
 */
public class KnapsackTotal {
    public static void main(String[] args) {
        //数量、容积
        int n,v;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        v = in.nextInt();
        //物品占用空间、价值
        int[] c = new int[n+1];
        int[] w = new int[n+1];
        for (int i = 1;i <=n;i++){
            c[i] = in.nextInt();
            w[i] = in.nextInt();
        }
        //进行动态规划计算
        int[] f = new int[v+1];
        for (int i = 1;i <= n;i++){
            for (int j = c[i];j <=v;j++){
                //从左到右更新
                //f[j]：容量为j，但是没有第i个元素的最优解
                //f[j-c[i]]:放入一个i之前的最优解，更新当前j为放入一个i后的最优解。再次回到更新后的值，便表示放入两个i后的最优解
                f[j] = Math.max(f[j-c[i]]+w[i],f[j]);
            }
        }
        System.out.println(f[v]);
    }
}
