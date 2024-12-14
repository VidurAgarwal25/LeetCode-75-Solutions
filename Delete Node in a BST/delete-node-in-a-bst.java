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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        TreeNode parent = null;
        TreeNode curr = root;

        while (curr != null && curr.val != key) {
            parent = curr;
            if (key < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (curr == null) {
            return root;
        }

        TreeNode leftHighest;

        if (parent == null) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                leftHighest = findHighest(root.left);
                leftHighest.right = root.right;
                root = root.left;
            }
        } else {
            if (parent.left == curr) {
                if (curr.left == null) {
                    parent.left = curr.right;
                } else if (curr.right == null) {
                    parent.left = curr.left;
                } else {
                    leftHighest = findHighest(curr.left);
                    leftHighest.right = curr.right;
                    parent.left = curr.left;
                }
            } else {
                if (curr.left == null) {
                    parent.right = curr.right;
                } else if (curr.right == null) {
                    parent.right = curr.left;
                } else {
                    leftHighest = findHighest(curr.left);
                    leftHighest.right = curr.right;
                    parent.right = curr.left;
                }
            }
        }

        return root;
    }

    private TreeNode findHighest(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
}
