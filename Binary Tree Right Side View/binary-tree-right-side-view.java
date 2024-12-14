class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            TreeNode lastNode = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = q.poll();
                lastNode = currentNode;

                if (currentNode.left != null) q.add(currentNode.left);
                if (currentNode.right != null) q.add(currentNode.right);
            }

            res.add(lastNode.val);
        }

        return res;
    }
}
