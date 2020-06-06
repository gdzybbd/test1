package shuzu;

import org.junit.Test;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution53 {
    public int missingNumber(int[] nums) {
        int arg=-1;
        int i =0;
        if(nums.length==1&&nums[0]==0){
            return 1;
        }
        if(nums.length==1&&nums[0]==1){
            return 0;
        }
//        if(nums[0]==1){
//            return 0;
//        }
        for (; i <nums.length ; i++) {
            if (nums[i]>i){
//                return i;
                arg=i;
                break;
            }
        }
        if(i==nums.length&&arg==-1){
            arg=i;
        }
        return arg;
//        return nums.length;

    }

    /**
     * 排序数组中的搜索问题，首先想到 二分法 解决。
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums){
        int r =0;
        int l =nums.length-1;
        while (r<=l){
            int m =(r+l)/2;
            if (nums[m]==m){
                r=m+1;
            }else {
                l=m-1;
            }
        }
        return r;
    }
}
