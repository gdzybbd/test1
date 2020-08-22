package shuzu;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Soution64 {
    public int minPathSum(int[][] grid) {
        int r=grid[0].length,c=grid.length;
        int[][] dp=new int[c][r];
        dp[0][0]=grid[0][0];
        for (int i = 1; i <c ; i++) {
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for (int i = 1; i <r ; i++) {
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }

        for (int i = 1; i <c ; i++) {
            for (int j = 1; j <r ; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[c-1][r-1];
    }

    /**
     * 可以将二位数组压缩成一维
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if (j==0&&i==0){
                    continue;
                }
                if (i==0){
                    grid[i][j]=grid[i][j-1]+grid[i][j];
                }
                if (j==0){
                    grid[i][j]=grid[i-1][j]+grid[i][j];
                }
                grid[i][j]=Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
