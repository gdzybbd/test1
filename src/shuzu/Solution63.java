package shuzu;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int r=obstacleGrid[0].length;
        int d=obstacleGrid.length;
        int count=0;
        int[][] dp=new int[d][r];
        //第一行和第一列如果没有障碍每一个格子到达的方法只能有一种 ，如果中间有障碍，后面的格子就没有办法到达
        for (int i = 0; i <d&&obstacleGrid[i][0]==0 ; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i <r&&obstacleGrid[0][i]==0 ; i++) {
            dp[0][i]=1;
        }

        for (int i = 1; i <d ; i++) {
            for (int j = 1; j <r ; j++) {
                if (obstacleGrid[i][j]==0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[d-1][r-1];
    }


    public int uniquePaths(int m, int n) {
        int[][] dp=new int[n][m];
        for (int i = 0; i <m ; i++) {
            dp[0][i]=1;
        }
        for (int i = 0; i <n ; i++) {
            dp[i][0]=1;
        }

        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <m ; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }
}
