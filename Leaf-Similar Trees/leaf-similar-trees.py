# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def leafSimilar(self, root1, root2):
        """
        :type root1: Optional[TreeNode]
        :type root2: Optional[TreeNode]
        :rtype: bool
        """
        def collectLeaves(node):
            if not node:
                return []
            if not node.left and not node.right:
                return [node.val]
            return collectLeaves(node.left) + collectLeaves(node.right)
        
        return collectLeaves(root1) == collectLeaves(root2)
