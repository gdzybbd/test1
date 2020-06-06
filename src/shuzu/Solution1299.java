package shuzu;

import org.junit.Test;

/**
 *
 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。

 完成所有替换操作后，请你返回这个数组。



 示例：

 输入：arr = [17,18,5,4,6,1]
 输出：[18,6,6,6,1,-1]
 */

public class Solution1299 {
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i <arr.length-1 ; i++) {
                arr[i]=max(i+1,arr);
        }
        arr[arr.length-1]=-1;
        return arr;
    }

    public int max(int i ,int[]arr){
        int max=0;
        for (int j = i; j <arr.length ; j++) {
            max=Math.max(max,arr[j]);
        }
        return max;
    }
    //找到右侧最大的，转换思路：
    //从右往左遍历，设右侧即使最大的。
        public  int[] replaceElements2(int[] arr){
            int max=arr[arr.length-1];
            for (int i = arr.length-2; i >=0 ; i--) {
                int temp=arr[i];
                arr[i]=max;
                if (temp>max){
                    max=temp;
                }
            }
            arr[arr.length-1]=-1;
            return arr;
        }


}
