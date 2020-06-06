package shuzu;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_53 {
    /**
     * 只要找到最大的连续字串的和即可，所以判断遍历到当前的元素对和有无增幅影响
     * 所以第一个元素一定是一个正数
     * 如果当前元素将之前的所有正向增幅全部冲抵，则该元素的坏元素，直接舍弃。
     * 然后向下遍历并记录和。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum=0;
        int ans=nums[0];

        for(int num:nums){
            if (sum>0){
                sum+=num;
            }else {
                sum=num;
            }
            ans=Math.max(ans,sum);
        }
        return ans;
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     *  
     *
     * 示例 1:
     *
     * 给定 nums = [3,2,2,3], val = 3,
     *
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     *
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param val
     * @return
     */
    public int removeElement27(int[] nums, int val) {
        int j=0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }

    public int removeElement27_2(int[] nums, int val){
        int l=0;
        int r=nums.length-1;
        while (l<r){
            if (nums[l]==val){
                r--;
            }else {
                l++;
            }
        }
        return l;
    }

}
