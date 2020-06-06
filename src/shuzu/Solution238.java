package shuzu;

import jdk.nashorn.internal.objects.annotations.Constructor;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 * <p>
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * <p>
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution238 {

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        for (int i = 0; i < output.length; i++) {
            if (i == 0) {
                output[i] = res(nums, i + 1, nums.length);
            }
            if (i == nums.length - 1) {
                output[i] = res(nums, 0, nums.length - 1);
            }
            output[i] = res(nums, 0, i) * res(nums, i + 1, nums.length);
        }
        Solution238 a = new Solution238();

        return output;
    }

    public int res(int[] a, int star, int end) {
        int res = 1;
        for (int i = star; i < end; i++) {
            res *= a[i];
        }
        return res;
    }

    /**
     * 先计算前缀积
     * 然后通过一个变量保存后缀积
     * 相乘得出结果
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf_2(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];

        output[0] = 1;
        //求出前缀积
        for (int i = 1; i < len; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }
        //后缀积第一个
        int res = 1;
        //注意：此步为计算结果数组，用前缀积乘后缀积
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] = output[i] * res;
            //得出下一步的后缀积
            res *= nums[i];
        }
        return output;
    }

    /**
     * 152
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
     * 并返回该子数组所对应的乘积。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * <p>
     * 示例 2:
     * <p>
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 动态规划问题通常用于计算多阶段决策问题的最优解。
     * 多阶段，是指解决一个问题有多个步骤；
     * 最优解，是指「最优子结构」。
     *
     * 动态规划有三个概念很重要：
     * 重复子问题：因为重复计算，所以需要「空间换时间」，记录子问题的最优解；
     * 最优子结构：规模较大的问题的最优解，由各个子问题的最优解得到；
     * 无后效性（上面已经解释）。
     *
     * 动态规划有两个特别关键的步骤
     * 设计状态：
     * 有些题目问啥，就设计成什么；
     * 如果不行，只要有利于状态转移，很多时候，就可以设计成状态；
     *
     * 根据过往经验；
     * 还有一部分问题是需要在思考的过程中调整的，例如本题。
     * 推导状态转移方程：通常是由问题本身决定的。
     * 动态规划问题思考的两个方向：
     *
     * 自顶向下：即「递归 + 记忆化」，入门的时候优先考虑这样做；
     * 自底向上：即「递归」，从一个最小的问题开始，逐步得到最终规模问题的解。
     * 后面问题见得多了，优先考虑这样做，绝大部分动态规划问题可以「自底向上」通过递推得到。
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/maximum-product-subarray/solution/dong-tai-gui-hua-li-jie-wu-hou-xiao-xing-by-liweiw/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int len = nums.length;
        //0为最小值，1为最大值
        int[][] temp = new int[len][2];
        //初始化,数组的第一个设置为最大值和最小值
        temp[0][0] = nums[0];
        temp[0][1] = nums[0];


        for (int i = 1; i < len; i++) {

            if (nums[i] > 0) {
                temp[i][0] = Math.min(nums[i], temp[i - 1][0] * nums[i]);
                temp[i][1] = Math.max(nums[i], temp[i - 1][1] * nums[i]);
            } else {
                //此条件下最大值和最小值和之前状态发生反转！
                temp[i][0] = Math.min(nums[i], temp[i - 1][1] * nums[i]);
                temp[i][1] = Math.max(nums[i], temp[i - 1][0] * nums[i]);
            }
        }

        int res = temp[0][1];

        for (int i = 0; i < len; i++) {
            res = Math.max(res, temp[i][1]);
        }

        return res;
    }

    /**
     * 空间优化
     *
     * @param nums
     * @return
     */
    public int maxProduct_2(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }
        //初始化
        int premax = nums[0];
        int premin = nums[0];

        //滚动变量！！！
        int max;
        int min;

        //结果从初始化值开始比较
        int res = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                max = Math.max(nums[i], nums[i] * premax);
                min = Math.min(nums[i], nums[i] * premin);
            } else {
                max = Math.max(nums[i], premin * nums[i]);
                min = Math.max(nums[i], premax * nums[i]);
            }
            res = Math.max(res, premax);


            //进行滚动!!!
            premax = max;
            premin = min;
        }
        return res;
    }
}
