# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        res = []
        if not root:
            return res
        
        from collections import deque
        q = deque([root])
        
        while q:
            level_size = len(q)
            last_node = None
            
            for _ in range(level_size):
                current_node = q.popleft()
                last_node = current_node
                
                if current_node.left:
                    q.append(current_node.left)
                if current_node.right:
                    q.append(current_node.right)
            
            res.append(last_node.val)
        
        return res
