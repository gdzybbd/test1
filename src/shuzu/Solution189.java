package shuzu;

import java.util.Arrays;

/**
 *给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution189 {
    /**
     * 暴力方法，逐一反转
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int len =nums.length;
        int pre=0;
        int temp=0;
        for (int i = 0; i <k ; i++) {
            pre=nums[len-1];
            for (int j = 0; j <len ; j++) {
                temp=nums[j];
                nums[j]=pre;
                pre=temp;
            }
        }
    }

    /**
     * 先全部反转，然后将k前后分别反转。
     * @param nums
     * @param k
     */
    public void rotate_1(int[] nums, int k){
        //理解为防止下表越界，减少无效次数？
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    /**
     * 反转的辅助方法
     * @param a
     * @param star
     * @param end
     */
    public void reverse(int [] a,int star,int end ){
        int len =a.length;
        int temp=0;
        while (star<end){
            temp=a[star];
            a[star]=a[end];
            a[end]=temp;
        }
    }

    /**
     * 辅助数组
     * @param nums
     * @param k
     */
    public void rotate_2(int[] nums, int k){
        int [] a=new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            //余数定理
            a[(k+i)%nums.length]=nums[i];
        }

        for (int i = 0; i <nums.length ; i++) {
            nums[i]=a[i];
        }
    }
}
