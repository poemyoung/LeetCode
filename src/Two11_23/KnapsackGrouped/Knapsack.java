package Two11_23.KnapsackGrouped;

import java.util.Scanner;

/**
 * 分组背包问题
 */
public class Knapsack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nG = in.nextInt();
        int v = in.nextInt();
        int[] f = new int[v+1];
        for (int i = 0;i < nG;i++){
            int num = in.nextInt();
            int[] itemsV = new int[num+1];
            int[] itemValue = new int[num+1];
            for (int j = 0;j < num;j++){
                itemsV[j] = in.nextInt();
                itemValue[j] = in.nextInt();
            }
            //数组更新循环
            for (int w = v;w >= 1;w--) {
                for (int k = 0; k < num; k++) {
                    //单组内物品循环
                    if(w >= itemsV[k])
                    f[w] = Math.max(f[w],f[w - itemsV[k]]+itemValue[k]);
                }
            }
        }
        System.out.println(f[v]);
    }
}
