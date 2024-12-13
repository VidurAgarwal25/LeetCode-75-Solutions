/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int pathSum(TreeNode* root, int t) {
        if(root==NULL)
        return 0;
        int count = 0;
        count+=countPaths(root,t);
        count+=pathSum(root->left,t);
        count+=pathSum(root->right,t);
        return count;
    }
    int countPaths(TreeNode* r, long t){
        if(r==NULL)
        return 0;
        int count=0;
        if(r->val==t)
        count++;
        count+=countPaths(r->left, t-r->val);
        count+=countPaths(r->right, t-r->val);
        return count;
    }
};