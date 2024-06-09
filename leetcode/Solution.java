class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int[] arr : dp ){
            Arrays.fill(arr,-1);
        }
        return coinChangeUntil(coins,n-1,amount,dp);
    }

    public int coinChangeUntil(int[] coins,int idx,int amount,int[][] dp) {
        if (amount == 0) return 0;

        if(idx == 0) {
            if( amount % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if( dp[idx][amount] != -1 ){
            return dp[idx][amount];
        }

        int notTaken = coinChangeUntil(coins,idx-1,amount,dp);

        int taken = 0;
        if(coins[idx] <= amount){
            taken = coinChangeUntil(coins,idx,amount-coins[idx],dp);
        }

        return dp[idx][amount] = taken + notTaken;
    }
}