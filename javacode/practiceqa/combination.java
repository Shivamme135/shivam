package shivam.javacode.practiceqa;

import java.util.Scanner;

public class combination {

        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int coin : coins) {

                for (int i = coin; i <= amount; i++) {
                    dp[i] += dp[i - coin];
                }
            }
            return dp[amount];
        }

        public static void main(String[] args) {
            combination cc = new combination();
            int[] coins = {1, 2, 3, 4};
            int sum = 2;
            System.out.println(cc.coinChange(coins, sum)); // Output: 4
        }
    }


