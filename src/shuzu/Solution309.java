package shuzu;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * 输入: [1,2,3,0,2] [1,4,3,2,5,6,4,2,3,4]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        if (prices==null||prices.length<2){
            return 0;
        }
        int len=prices.length;
        int dp[][] =new int[len][3];
        dp[0][0]=-prices[0];
        for (int i = 1; i <len ; i++) {
            //持有            持有         不持有买入
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            //不持有 不可买  持有卖出
            dp[i][1]=dp[i-1][0]+prices[i];
            //不持有 可买      不可买不买     可买不买
            dp[i][2]=Math.max(dp[i-1][1],dp[i-1][2]);
        }
        //最后一天只有不持有不能买 和不持有能买  持有的状态是亏钱的
        int max = Math.max(dp[len-1][1],dp[len][2]);
        return max;
    }


    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int dp0 = -prices[0], dp1 = 0, dp2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp0 = Math.max(dp0, dp2 - prices[i]);
            int tmep1 = dp0 + prices[i];
            int temp2 = Math.max(dp1, dp2);
            dp0 = temp0;
            dp1 = tmep1;
            dp2 = temp2;
        }
        int maxProfit = Math.max(dp1, dp2);
        return maxProfit;
    }

}
