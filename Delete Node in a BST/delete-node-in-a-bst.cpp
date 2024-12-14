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
    TreeNode* deleteNode(TreeNode* root, int key) {
        if (root == NULL)
            return NULL;
        TreeNode* parent = NULL;
        TreeNode* curr = root;
        while (curr != NULL && curr->val != key) {
            parent = curr;
            if (curr->val > key) {
                curr = curr->left;
            } else if (curr->val < key) {
                curr = curr->right;
            } else {
                break;
            }
        }
        if (curr == NULL)
            return root;
        TreeNode* lefthighest;
        if (parent == NULL) {
            if (root->left == NULL)
                return root->right;
            else if (root->right == NULL)
                return root->left;
            else {
                lefthighest = findhighest(root->left);
                lefthighest->right = root->right;
                root = root->left;
            }
        } else {
            if (parent->left == curr) {
                if (curr->left == NULL) {
                    parent->left = curr->right;
                } else if (curr->right == NULL) {
                    parent->left = curr->left;
                } else {
                    lefthighest = findhighest(curr->left);
                    lefthighest->right = curr->right;
                    parent->left = curr->left;
                }
            }
            else{
                if (curr->left == NULL) {
                    parent->right = curr->right;
                } else if (curr->right == NULL) {
                    parent->right = curr->left;
                } else {
                    lefthighest = findhighest(curr->left);
                    lefthighest->right = curr->right;
                    parent->right = curr->left;
                }
            }
        }
        return root;
    }
    TreeNode* findhighest(TreeNode* r) {
        while (r->right != NULL) {
            r = r->right;
        }
        return r;
    }
};