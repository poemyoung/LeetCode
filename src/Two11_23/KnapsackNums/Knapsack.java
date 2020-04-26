package Two11_23.KnapsackNums;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 求背包问题方案数
 * 最优方案数
 */
public class Knapsack {
    public static void main(String[] args) {
        int mod = 1000000007;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int v = in.nextInt();
        //方案数组
        int[] g = new int[v+1];
        //肯定存在一种方案
        Arrays.fill(g, 1);
        int[] f = new int[v+1];
        Arrays.fill(f,-100000);
        f[0] = 0;
        for (int i = 0;i < n;i++){
            int ci = in.nextInt();
            int vi = in.nextInt();
            for (int j = v;j >= ci;j--){
                int tep = Math.max(f[j],f[j-ci]+vi);
                if(tep == f[j]&&tep!=f[j-ci]+vi){
                    //新的元素不加入成为最优方案
                    //即没有新的方案诞生
                    //容量不依赖于放入新元素前后元素进行更新
                }else if(tep==f[j-ci]+vi&&tep!=f[j]){
                    //新的元素加入
                    //新的方案诞生,新的方案加一，旧的方案减一（不成立）
                    //容量依赖于放入新元素之前的方案数进行更新
                    g[j] = g[j - ci];
                }else {
                    //都可，新的方案加一，旧的方案仍然成立
                    g[j] = (g[j-ci]+g[j]>=mod)?(g[j-ci]+g[j])-mod : (g[j-ci]+g[j]);
                }
                //更新f
                f[j] = tep;
            }
        }
        int res = 0;
        for (int i = 1;i<=v;i++){
            if(f[i] == f[v]){
                res+=g[i];
            }
        }
        System.out.println(res);
    }
}
