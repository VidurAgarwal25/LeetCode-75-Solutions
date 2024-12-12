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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int index = 0, maxsum = Integer.MIN_VALUE, height = 0;
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            int s = 0;
            height++;
            for (int i = 1; i <= count; i++) {
                TreeNode node = q.poll();
                s += node.val;
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            if (s > maxsum) {
                index = height;
                maxsum = s;
            }
        }
        return index;
    }
}
