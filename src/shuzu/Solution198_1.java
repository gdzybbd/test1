package shuzu;

import java.util.Arrays;

/**
 * 打家劫舍系列问题
 */
public class Solution198_1 {
    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组
     * 计算你不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * 示例 1
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2：
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len=nums.length;
        
        int[] dp=new int[len+1];

        dp[0]=0;

        dp[1]=nums[0];
        //dp[i]的值及nums[i-1]的值为dp[i-1]与dp[i-2]+nums[i-1]中的最大值
        for (int i = 2; i <=len ; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }

        return dp[len];
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     * 示例 1:
     * 输入: [2,3,2]
     * 输出: 3
     * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 示例 2:
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int rob_2(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        //转化为两种情况
        //1.可以偷第一个房子而不可以偷最后一个房子
        //2.不可以偷第一个房子而可以偷最后一个房子
        //将两个结果做对比
        return Math.max(myRob(Arrays.copyOfRange(nums,0,nums.length-1)),myRob(Arrays.copyOfRange(nums,1,nums.length)));
    }

    private int myRob(int[] nums) {
        int len =nums.length ;
        int[] dp = new int[len+1];
        dp[0]=0;
        dp[1]=nums[0];
        for (int i = 2; i <=len ; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
//        空间优化
//        int cur=0,pre=0,temp;
//        for (int i:nums){
//            temp=cur;
//            cur=Math.max(cur,pre+i);
//            pre=temp;
//        }
//        return cur;
        return dp[len];
    }
    //第三题--树（未完成）
}
