public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    public TreeNode() {}
    
    public TreeNode(int val) {
        this.val = val;
    }
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    
    public void longestPath(TreeNode r, char dir, int currlen, int[] maxPath) {
        if (r == null) {
            return;
        }
        
        maxPath[0] = Math.max(maxPath[0], currlen);
        
        longestPath(r.left, 'l', dir == 'l' ? 1 : currlen + 1, maxPath);
        
        longestPath(r.right, 'r', dir == 'r' ? 1 : currlen + 1, maxPath);
    }

    public int longestZigZag(TreeNode root) {
        int[] maxPath = new int[1];
        longestPath(root, 'l', 0, maxPath);
        longestPath(root, 'r', 0, maxPath);
        return maxPath[0];
    }
}
