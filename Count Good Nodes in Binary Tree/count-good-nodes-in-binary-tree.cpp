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
    int goodNodes(TreeNode* root) {
        int count=0;
        if(!root)
        return count;
        countGoodNodes(root, count, root->val);
        return count;
    }
    void countGoodNodes(TreeNode* root, int& count, int maxValuePerLevel){
        if(!root)
        return;
        if(root->val>=maxValuePerLevel){
            count++;
            maxValuePerLevel = root->val;
        }
        countGoodNodes(root->left,count,maxValuePerLevel);
        countGoodNodes(root->right,count,maxValuePerLevel);
    }
};