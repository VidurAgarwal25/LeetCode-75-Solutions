# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def goodNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        def countGoodNodes(node, maxValue):
            if not node:
                return 0
            count = 1 if node.val >= maxValue else 0
            maxValue = max(maxValue, node.val)
            count += countGoodNodes(node.left, maxValue)
            count += countGoodNodes(node.right, maxValue)
            return count

        return countGoodNodes(root, root.val)
