package offer;

import org.junit.Test;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，
 * 则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution17 {
    public int[] printNumbers(int n) {
        int[] res=new int[(int)(Math.pow(10,n)-1)];
        for (int i = 1; i <res.length ; i++) {
            res[i]=i++;
        }
        return res;
    }

    /**
     * 题目要求返回int[] 则不需要考虑int类型2^32 超出范围的可能。
     * 如果考虑大数问题，则应该使用String解决
     */
    @Test
    public void test(){
        double pow = Math.pow(10, 0);
        System.out.println(pow-1);
    }
}
