package FAIL_LIST.CoinsCombine;

import java.util.Arrays;

class CoinCombine{
    public int waysToChange(int n) {
        //负无穷
        int INF = 1000000;
        //mod
        int mod = 1000000007;
        //数组：存储方案数(每个面值下）
        int[] wayCount = new int[n+1];
        Arrays.fill(wayCount,1);
        //数组：存储硬币面值
        int[] coins  = new int[4];
        coins[0] = 1;
        coins[1] = 5;
        coins[2] = 10;
        coins[3] = 25;
        //每个硬币进行循环
        for (int i = 1;i < 4;i++){
            for (int j = coins[i];j <= n;j++){
                //完全背包问题
                wayCount[j]+=wayCount[j-coins[i]];
                if(wayCount[j]>=mod){
                    wayCount[j]-=mod;
                }
            }
        }

        return  wayCount[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new CoinCombine().waysToChange(n));
    }
}