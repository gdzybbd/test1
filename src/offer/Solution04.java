package offer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 * 限制：
 * 0 <= n <= 1000
 * 0 <= m <= 1000
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0||matrix[0].length==0){
            return false;
        }
        int n=matrix.length,m=matrix[0].length;
        for (int i = 0; i <n ; i++) {
            if (target>matrix[i][m-1]){
                continue;
            }
            for (int j = 0; j <m ; j++) {
                if (matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 从右上角开始查找
     * 寻找边界条件
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, col = matrix[0].length;
        //从第0行col - 1列开始查找，也就是第1行最后一列的那个数字开始
        int row = 0;
        int column = col - 1;
        while (row<rows&&column>=0){
            int temp=matrix[row][column];
            if (target==temp){
                return true;
            }else if (target>temp){
                row++;
            }else {
                column--;
            }
        }
        return false;
    }
}
