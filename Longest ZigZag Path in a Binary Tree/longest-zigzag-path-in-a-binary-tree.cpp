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
    
    void longestPath(TreeNode* r, char dir,int currlen, int &maxPath){
        if(r==NULL)
        return;
        maxPath=max(maxPath,currlen);
        longestPath(r->left,'l',dir=='l'?1:currlen+1,maxPath);
        longestPath(r->right,'r',dir=='r'?1:currlen+1,maxPath);
    }
    int longestZigZag(TreeNode* root) {
        int maxPath=0;
        longestPath(root,'l',0, maxPath);
        longestPath(root,'r',0, maxPath);
        return maxPath;
    }
};