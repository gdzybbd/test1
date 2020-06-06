package shuzu;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
       int len=digits.length;
        for (int i = len-1; i >=0 ; i--) {
            digits[i]++;
            digits[i]%=10;
            if (digits[i]!=0){
                return digits;
            }
        }

        int[] a= new int[len+1];
        a[0]=1;
        return a;
    }

    public int maxProfit121(int[] prices) {
        int ans=0;
        for (int i = prices.length-1; i >0 ; i--) {
            for (int j = i-1; j >=0 ; j--) {
                    ans=Math.max(prices[i]-prices[j],ans);
            }
        }
        return ans;
    }

    /**
     * 记录最小值
     * “动态规划”用于多阶段最优化问题的求解。
     * @param prices
     * @return
     */
    public int maxProfit121_2(int[] prices){
        int min=prices[0];
        int max=0;
        for (int i = 0; i <prices.length ; i++) {
            min=Math.min(min,prices[i]);
            max=Math.max(max,prices[i]-min);
        }
        return max;
    }

    /**
     * 动态规划
     * @param prices
     * @return
     */
    public int maxProfit121_3(int[] prices){
        return 0;

    }



}

