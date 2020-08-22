package shuzu;

import java.util.*;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution350 {
    /**
     * 使用双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res =new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0,j=0; i <nums1.length&&j<nums2.length ; ) {
            if (nums1[i]>nums2[j]){
                j++;
            }else if (nums1[i]<nums2[j]){
                i++;
            }else {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] c = new int[res.size()];
        for(int i = 0; i < c.length; i++) {
            c[i] = res.get(i);
        }
        return c;
    }

    /**
     * 考虑内存和磁盘限制
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>((int)(nums1.length / 0.75F + 1.0F));
        Map<Integer, Integer> map2 = new HashMap<>((int)(nums1.length / 0.75F + 1.0F));
        for (int integer :nums1 ) {
            map1.put(integer,map1.getOrDefault(integer,0)+1);
        }

        for (int integer :nums2 ) {
            map2.put(integer,map2.getOrDefault(integer,0)+1);
        }

        ArrayList<Integer> list = new ArrayList();
        for (Integer m1 : map1.keySet()) {
            if (map2.containsKey(m1)){
                for (int i = 0; i <Math.min(map1.get(m1),map2.get(m1)) ; i++) {
                    list.add(m1);
                }
            }
        }
       int[] res =new int[list.size()];
        for (int i = 0; i <res.length ; i++) {
            res[i]=list.get(i);
        }
        return res;
    }
}
