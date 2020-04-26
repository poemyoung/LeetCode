package Two11_23.knapsackTwoDim;

import java.util.Scanner;

/**
 * 二维背包问题
 */
public class Knapsack {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        int v = in.nextInt();
        int w = in.nextInt();
        int[][] f = new int[110][110];
        for (int i = 0;i < n;i++){
            int vi = in.nextInt();
            int wi = in.nextInt();
            int value = in.nextInt();
            for (int j = v;j >= vi;j--){
                for (int k = w;k >=wi;k--){
                    f[j][k] = Math.max(f[j][k],f[j-vi][k-wi]+value);
                }
            }
        }
        System.out.println(f[v][w]);
    }
}
