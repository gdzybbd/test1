package shuzu;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 要求O(N) 不能使用排序
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 *
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        //Arrays.sort(nums);
        int len=nums.length;
        Set<Integer> s=new HashSet<>();
        for (int i = 0; i <len ; i++) {
            if (!s.contains(nums[i])){
                s.add(nums[i]);
            }
        }
        int[] arr =new int[s.size()];
        Iterator<Integer> iterator = s.iterator();
        int i =0;
        while (iterator.hasNext()){
            int o=iterator.next();
            arr[i++]=o;
        }
        Arrays.sort(arr);
        int k=-1;
        int res=1;
        for (int j = 0; j <arr.length; j++) {
            if (arr[j]==res){
                k=j;
                break;
            }
        }
        if (k==-1){
            return res;
        }
        for (int j = k; j <arr.length ; j++) {
            if (res!=arr[j]){
                return res;
            }
            res++;
        }
        return res;
    }



    @Test
    public void test1(){
        int[] a={3,4,-1,1};
        int i = firstMissingPositive(a);
        System.out.println(i);
    }
}
