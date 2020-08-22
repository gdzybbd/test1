package shuzu;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length==0||target<nums[0]){
            return 0;
        }
        if (target>nums[nums.length-1]){
            return nums.length;
        }
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int cur = (l+r)/2;
            if (target>nums[cur]){
                l=cur+1;
            }else if(target<nums[cur]){
                r=cur-1;
            }else {
                return cur;
            }
        }
        return l;
    }
    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * 示例 1:
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例 2:
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int search704(int[] nums, int target) {
        if (nums.length==0){
            return -1;
        }
        int l=0,r=nums.length-1;
        while (l<r){
            int mid = (l+r)>>>1;
            if (target<nums[mid]){
                r=mid;
            }else if (target>nums[mid]){
                l=mid+1;
            }else {
                return mid;
            }
        }
        return target==nums[l]?l:-1;
    }

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
     * 找出给定目标值在数组中的开始位置和结束位置。
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * 如果数组中不存在目标值，返回 [-1, -1]。
     * 示例 1:
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例 2:
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] searchRange34(int[] nums, int target) {
        int[] res ={-1,-1};
        int l=0,r=nums.length-1,index=0;
        if (nums.length==0||target<nums[0]||target>nums[nums.length-1]){
            return res;
        }
        while (l<=r){
            if (target>nums[l]){
                l++;
            }
            if (target<nums[r]){
                r--;
            }
            if (target==nums[r]&&target==nums[l]){
                res[0]=l;
                res[1]=r;
                return res;
            }
        }
        if (res[0]!=res[1]){
            res[1]=res[0];
        }
        return res;
    }
}
