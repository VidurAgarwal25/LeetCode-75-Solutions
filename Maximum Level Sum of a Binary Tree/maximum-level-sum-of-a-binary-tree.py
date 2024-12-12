# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def maxLevelSum(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: int
        """
        from collections import deque
        q = deque([root])
        index, maxsum, height = 0, float('-inf'), 0
        
        while q:
            count = len(q)
            level_sum = 0
            height += 1
            
            for _ in range(count):
                node = q.popleft()
                level_sum += node.val
                if node.left:
                    q.append(node.left)
                if node.right:
                    q.append(node.right)
            
            if level_sum > maxsum:
                index = height
                maxsum = level_sum
        
        return index
