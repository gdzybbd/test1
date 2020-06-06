package shuzu;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        //入参判断
        if (matrix.length == 0) {
            return new int[0];
        }

        int col = matrix.length;
        int row = matrix[0].length;
        //左
        int l = 0;
        //右
        int r = row - 1;
        //上
        int t = 0;
        //下
        int d = col - 1;

        int i = 0;

        int[] res = new int[row * col];

        while (true) {
            //左往右
            for (int j = l; j <= r; j++) {
                res[i++] = matrix[t][j];
            }
            if (++t > d) {
                break;
            }
            //上到下
            for (int j = t; j <= d; j++) {
                res[i++] = matrix[j][r];
            }
            if (l > --r) {
                break;
            }
            //右往左
            for (int j = r; j >= l; j--) {
                res[i++] = matrix[d][j];
            }
            if (t > --d) {
                break;
            }
            //下到上
            for (int j = d; j >= t; j--) {
                res[i++] = matrix[j][l];
            }
            if (++l > r) {
                break;
            }
        }
        return res;
    }

}
