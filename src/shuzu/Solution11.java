package shuzu;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * 示例 1：
 * 输入：[3,4,5,1,2] 4 5 1 2 3
 * 输出：1
 * 示例 2：
 * 输入：[2,2,2,0,1]
 * 输出：0
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution11 {
    public int minArray(int[] numbers) {
        int l=0,r=numbers.length-1;
        while (l<r){
            int mid= (r-l)/2+l;
            if (numbers[r]<numbers[mid]){
                l=mid+1;
            }else if(numbers[r]>numbers[mid]){
                r=mid;
            }else {
                r--;
            }
        }
        return numbers[l];
    }
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 请找出其中最小的元素。
     * 注意数组中可能存在重复的元素。
     * 示例 1：
     * 输入: [1,3,5]
     * 输出: 1
     * 输入: [2,2,2,0,1]
     * 输出: 0
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int findMin(int[] nums) {
        int l =0,r=nums.length-1;
        while (l<r){
            int mid=(r-l)/2+l;
            if (nums[mid]<nums[r]){
                r=mid;
            }else if (nums[mid]>nums[r]){
                l=mid+1;
            }else {
                r--;
            }
        }
        return nums[l];
    }
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * 请找出其中最小的元素。
     * 你可以假设数组中不存在重复元素。
     * 示例 1:
     * 输入: [3,4,5,1,2]
     * 输出: 1
     * 示例 2:
     * 输入: [4,5,6,7,0,1,2]
     * 输出: 0

     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int findMin153(int[] nums) {
        int left =0, right =nums.length-1;
        while (left<right){
            int mid =(right-left)/2+left;
            if (nums[mid]<nums[right]){
                right=mid;
            }else {
                left=mid+1;
            }
        }
        return nums[left];
    }
}
