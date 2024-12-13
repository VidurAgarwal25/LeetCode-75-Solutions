# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def pathSum(self, root, targetSum):
        """
        :type root: Optional[TreeNode]
        :type targetSum: int
        :rtype: int
        """
        if root is None:
            return 0

        count = 0
        count += self.countPaths(root, targetSum)
        count += self.pathSum(root.left, targetSum)
        count += self.pathSum(root.right, targetSum)
        return count

    def countPaths(self, node, targetSum):
        if node is None:
            return 0

        count = 0
        if node.val == targetSum:
            count += 1
        count += self.countPaths(node.left, targetSum - node.val)
        count += self.countPaths(node.right, targetSum - node.val)
        return count
