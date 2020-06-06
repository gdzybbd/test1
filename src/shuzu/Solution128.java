package shuzu;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 示例:
 * <p>
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {

        //建立一个hash表
        Set<Integer> numsSet = new HashSet<Integer>();

        int maxlength = 0;
        //去重
        for (int num : nums) {
            numsSet.add(num);
        }

        for (int num : numsSet) {
            //因为要找到最大连续数组:
            //1.已知存在x，x+1，x+2...x+y，那么这个最大长度为y+1
            //2.设想遍历当前的元素为x，那么该数组中就 不存在x-1，如果存在则该元素不为x（头元素）
            //3.当找到头元素后，需要遍历找到x+1....x+y，设置两个滚动的变量
            //4.输出最大长度
            if (!numsSet.contains(num - 1)) {
                //滚动变量
                int currentNum = num;
                int currentLen = 1;
                //寻找X+y
                while (numsSet.contains(currentNum + 1)) {

                    currentNum += 1;
                    currentLen += 1;

                }
                maxlength = Math.max(currentLen, maxlength);
            }
        }
        return maxlength;
    }
}
/**
 *
 */
