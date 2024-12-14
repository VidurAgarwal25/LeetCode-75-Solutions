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
    vector<int> rightSideView(TreeNode* root) {
        vector<int> res;
        queue<TreeNode*> q;
        if (root == NULL)
            return res;
        q.push(root);
        while (!q.empty()) {
            int count = q.size();
            for (int i = 1; i <= count; i++) {
                if (q.front()->left != NULL)
                    q.push(q.front()->left);
                if (q.front()->right != NULL)
                    q.push(q.front()->right);
                if (i == count)
                    res.push_back(q.front()->val);
                q.pop();
            }
        }
        return res;
    }
};