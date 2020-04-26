package Two11_23.Knapsack01;

import java.util.Scanner;

/**
 * 01背包问题
 * 对于f[i][j]，表示把前i个物品放入容量为j的背包中的最优解，即最大价值
 * j是背包剩余容量
 */
public class Knapsack {

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
        //动态规划二维数组
        int[][] f = new int[n+1][v+1];
        f[0][0] = 0;
        //计算
        for (int i = 1;i <= n;i++){
            //物品数量
            for (int j = 1;j <= v;j++){
//                背包剩余容量
                //对于第i个元素，只需选择放或者不放
                //选择不放
                f[i][j] = f[i-1][j];
                //选择放，满足放的条件
                //放的条件：剩余容量为j的背包，不能放超过j容量的物品
                if (j >= c[i]){
                    //f[i-1][j-c[i]],不放该物品，且没有占用空间时的最优解
                    //加上放入该物品时的最优解
                    f[i][j] = Math.max(f[i][j],f[i-1][j-c[i]]+w[i]);
                }
            }
        }
        //比较,要求的是容量为v,j = v，物品为n, i==n的最优解
      System.out.println(f[n][v]);
    }
}
