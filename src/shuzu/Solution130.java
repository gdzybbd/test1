package shuzu;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surrounded-regions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution130 {
    int m = 0;
    int n = 0;

    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) {
            return;
        }
        n = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                DFS(board, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                DFS(board, m - 1, i);
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[i][0] == 'O') {
                DFS(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                DFS(board, i, n-1);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    continue;
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void DFS(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'M';
        DFS(board, x - 1, y);
        DFS(board, x, y - 1);
        DFS(board, x + 1, y);
        DFS(board, x, y + 1);
    }
}
