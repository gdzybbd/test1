package shuzu;

import java.util.Arrays;

/**
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/duplicate-zeros
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1089 {
    public void duplicateZeros(int[] arr) {

        //采用一个辅助数组，然后用双指针同时遍历两个数组，直接对原数组进行覆盖填充。
        int[] ints = Arrays.copyOf(arr, arr.length);
        for (int i = 0, j = 0; i <= arr.length - 1; i++) {
            if (ints[j] != 0) {
                arr[i] = ints[j];
                j++;
            } else {
                if (i == arr.length - 1) {
                    arr[i] = 0;
                } else {
                    arr[i] = 0;
                    arr[++i] = 0;
                    j++;
                }

            }
        }
    }

    public void duplicateZeros2(int[] arr) {
        int count = 0;
        int len = arr.length;
        int i = 0;
        // 统计需要复制的0的个数，复制count个0，则会挤出原数组count个值
        // i进行扫描，遇到0则count自增
        // 若i+count大于原数组长度，则停止扫描，后面的直接舍弃
        while (i + count < len) {
            if (arr[i++] == 0) {
                count++;
            }
        }
        // 因为循环中i自增到了下一个值，此处i--返回到上一个结束值
        i--;
        int j = len - 1;
        // i从结束值开始，j从数组末尾开始，从后往前扫描，开始复制
        // 特别需要注意的是：若最后一个数字是0，统计需要复制的0时统计了该数，但若复制一次，则数组可能越界
        // 此处+1判断，如果越界，则只复制本身
        if (count + i + 1 > len) {
            arr[j--] = arr[i--];
            count--;
        }
        // 遇0则复制两次，非0则复制本身
        // count<=0时，说明前面没有0了，保持不变就行
        while (count > 0) {
            arr[j--] = arr[i];
            if (arr[i] == 0) {
                arr[j--] = arr[i];
                count--;
            }
            i--;
        }
    }

}
