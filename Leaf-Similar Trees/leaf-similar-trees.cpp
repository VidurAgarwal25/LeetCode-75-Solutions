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
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int>v1;
        vector<int>v2;
        calcLeaf(root1,v1);
        calcLeaf(root2,v2);
        return v1==v2;
    }
    void calcLeaf(TreeNode* r,vector<int> &v){
        if(r==NULL)
        return;
        if(r->left==NULL && r->right==NULL)
        v.push_back(r->val);
        calcLeaf(r->left,v);
        calcLeaf(r->right,v);
    }
};