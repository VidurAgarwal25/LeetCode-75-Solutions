/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
    int maxLevelSum(TreeNode* root) {
        queue<TreeNode*> q;
        int index = 0, maxsum = INT_MIN, height = 0;
        q.push(root);
        while (!q.empty()) {
            int count = q.size();
            int s = 0;
            height++;
            for (int i = 1; i <= count; i++) {
                TreeNode* node = q.front();
                q.pop();
                s += node->val;
                if (node->left != NULL)
                    q.push(node->left);
                if (node->right != NULL)
                    q.push(node->right);
            }
            if (s > maxsum) {
                index = height;
                maxsum = s;
            }
        }
        return index;
    }
};