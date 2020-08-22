package shuzu;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] arr=new int[2];
        for (int i = 0; i <numbers.length-1 ; i++) {
            for (int j = i+1; j <numbers.length ; j++) {
                if (numbers[i]+numbers[j]==target){
                    arr[0]=i;
                    arr[1]=j;
                }
            }
        }
        return arr;
    }

    /**
     * 二分法找到边界
     *
     * 
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        if (numbers==null||target<numbers[0]+numbers[1]||target>numbers[numbers.length-1]+numbers[numbers.length-2]||numbers.length<2){
            return  new int[]{-1,-1};
        }
        int mid=0;
        if(target>=numbers[0]+numbers[numbers.length-1]){
            mid=numbers.length-1;
        }else {
            int temp = target - numbers[0], i = 0, j = numbers.length - 1;
            mid = (i + j) / 2;
            if (temp > numbers[mid]) {
                i = mid + 1;
            } else if (temp < numbers[mid]) {
                j = mid - 1;
            } else {
                return new int[]{++i,++mid};
            }
            if (numbers[mid]>temp){
                mid-=1;
            }
        }
        int l=0,r=mid;
        while (l<mid){
            if (target<numbers[l]+numbers[r]){
              l++;
            }
            if (target>numbers[l]+numbers[r]){
                r--;
            }
            if (target==numbers[l]+numbers[r]){
                return new int[]{l,r};
            }
        }
        return new int[]{-1,-1};
    }

    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        if (target>nums[nums.length-1]) {
            return nums.length-1;
        }
        if (target<nums[0]){
            return 0;
        }
        while (l<r){
            int temp=(l+r)/2;
            if (target<nums[temp]){
                r=temp-1;
            }
            if (target>nums[temp]){
                l=temp+1;
            }
            if (target==nums[temp]){
                return temp;
            }
        }
        if (nums[l]<target){
            l+=1;
        }
        return l;
    }

    public int[] twoSum1(int[] numbers, int target) {
        int l = 0,r=numbers.length-1;
        while(l<r){
            if(numbers[l]+numbers[r]<target){
                l++;
            }else if(numbers[l]+numbers[r]>target){
                r--;
            }else{
                return new int[]{l+1,r+1};
            }
        }
        return new int[2];
    }

    public int[] twoSum3(int[] numbers, int target) {
        int l = 0,r=numbers.length-1;
        return null;
    }
}
