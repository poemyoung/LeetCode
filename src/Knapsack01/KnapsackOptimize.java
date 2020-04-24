package Knapsack01;

import java.util.Scanner;

/**
 * 优化空间复杂度，只使用一个一维数组进行操作
 * 也就是：该数组始终表示的是原二维数组的i-1的行
 * 因为我们每次在更新数组时，只需要查找i-1的行
 * 故下标应该从大到小更新，这样可以防止原来i-1的行被更新掉（因为计算总是依赖的左边）
 */
public class KnapsackOptimize {
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
        //动态规划一维数组
        int f[] = new int[v+1];
        for (int i = 1;i <=n;i++){
            for (int j = v;j >=1;j--){
                //更新i-1数组（原数组）为当前的i(当前数组）
                if(j >= c[i]){
                    f[j] = Math.max(f[j],f[j-c[i]]+w[i]);
                }
                //否则，不更新该值
            }
        }
        System.out.println(f[v]);
    }
}
