/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        if (root == null) return 0;
        countGoodNodes(root, count, root.val);
        return count[0];
    }

    private void countGoodNodes(TreeNode root, int[] count, int maxValuePerLevel) {
        if (root == null) return;
        if (root.val >= maxValuePerLevel) {
            count[0]++;
            maxValuePerLevel = root.val;
        }
        countGoodNodes(root.left, count, maxValuePerLevel);
        countGoodNodes(root.right, count, maxValuePerLevel);
    }
}
