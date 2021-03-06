package tree;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 *  3
 * / \
 * 9  20
 *  /  \
 * 15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 *      1
 *    /  \
 *    2   2
 *  / \
 * 3   3
 /   \
 4   4
 * 返回 false 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root==null){
            return true;
        }
        return Math.abs(num(root.left)-num(root.right))<=1&&isBalanced(root.right)&&isBalanced(root.left);
    }

    public int num(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(num(root.right),num(root.left))+1;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



}
