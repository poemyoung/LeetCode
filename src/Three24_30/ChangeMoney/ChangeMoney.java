package Three24_30.ChangeMoney;

import java.util.Arrays;

/**
 * 兑换零钱
 */
public class ChangeMoney {
    public int coinChange(int[] coins, int amount) {
        //动态规划数组
        int INF = 1;
        int[] dp = new int[amount+1];
        //只能从0更新起走
        Arrays.fill(dp,-INF);
        dp[0] = 0;
        //特殊情况处理
        if(coins.length == 0){
            return 0;
        }
        //循环赋值
        for (int i = 0;i < coins.length;i++){
            //更新
            for (int j = coins[i];j <= amount;j++){
                if(dp[j-coins[i]]!=-1) {
                    dp[j] = dp[j] == -1?dp[j-coins[i]]+1 : Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        ChangeMoney test = new ChangeMoney();
        System.out.println(test.coinChange(coins,amount));
    }
}

