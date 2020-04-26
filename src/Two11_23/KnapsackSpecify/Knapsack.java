package Two11_23.KnapsackSpecify;

import java.util.Scanner;

/**
 * 背包问题求具体方案
 */
public class Knapsack {
    public static void main(String[] args) {
        int INF = 1000000;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int v = in.nextInt();
        int[] nItem = new int[n+1];
        int[] vItem = new int[v+1];
        int[][] f = new int[n+2][v+1];
       //处理输入
        for (int i = 1;i <=n;i++){
            nItem[i] = in.nextInt();
            vItem[i] = in.nextInt();
        }
        //倒叙处理：好处：当我们从后往前处理时，实际上输入的是从前往后
        //这样可以保证处理到每个节点的字典序是递增的
        //也就是，第一个元素是输入时最后进行处理的元素
        for (int i = n;i >=1;i--){
            for (int j = 0;j<=v;j++){
                f[i][j] = f[i+1][j];
                if(j >=nItem[i])
                f[i][j] = Math.max(f[i+1][j],f[i+1][j-nItem[i]]+vItem[i]);
            }
        }
        //循环输出
//        for (int[] it:f){
//            System.out.println(Arrays.toString(it));
//        }
        int cap = v;
        for (int i = 1;i<=n;i++){
            if(cap < nItem[i])continue;
            if(f[i][cap] == f[i+1][cap-nItem[i]] + vItem[i]){
                //说明要取该物品
                System.out.print(i+" ");
                cap -= nItem[i];
            }
        }
    }
}
