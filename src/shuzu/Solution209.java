package shuzu;

import java.util.Arrays;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，
 * 并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。

 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        int res=nums.length+1;
        for (int i = 0; i <nums.length; i++) {
            if (nums[i]>=s){
                return 1;
            }
            int sum=nums[i];
            for (int j = i+1; j <nums.length ; j++) {
               if((sum+=nums[j])>=s){
                   res=Math.min(res,j-i+1);
                   break;
               }
            }
        }
        if (res==nums.length+1){
            return 0;
        }else {
            return res;
        }
    }
    //模拟队列处理
    public int minSubArrayLen1(int s, int[] nums){
        int l=0,r=0,sum=0,min=nums.length+1;
        while (r<nums.length){
            sum+=nums[r++];
            while (sum>=s){
                min=Math.min(min,r-l);
                sum-=nums[l++];
            }
        }
        return min==nums.length-1?0:min;
    }
    //二分查找法
    public int minSubArrayLen2(int s, int[] nums){
        int len =nums.length;
        int[] arr=new int[len+1];
        int res=len+1;
        //求出前缀和数组
        //注意两个循环的边界问题
        for (int i = 1; i <=len ; i++) {
            arr[i]=nums[i-1]+arr[i-1];
        }

        for (int i = 1; i <=len ; i++) {
            int target=s+nums[i-1];
            int end= Arrays.binarySearch(nums,target);
            //如果end<0,end则为插入点（比target大的数）
            if (end<0){
                end=-(end+1);
            }
            if (end<=len){
                res=Math.min(end-i+1,res);
            }
        }
        return res==len+1?0:res;
    }
}
