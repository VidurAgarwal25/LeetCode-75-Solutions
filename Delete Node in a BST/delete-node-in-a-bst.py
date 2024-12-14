# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution(object):
    def deleteNode(self, root, key):
        """
        :type root: Optional[TreeNode]
        :type key: int
        :rtype: Optional[TreeNode]
        """
        if root is None:
            return None
        
        parent = None
        curr = root
        
        while curr is not None and curr.val != key:
            parent = curr
            if key < curr.val:
                curr = curr.left
            else:
                curr = curr.right
        
        if curr is None:
            return root

        def find_highest(node):
            while node.right is not None:
                node = node.right
            return node

        if parent is None:
            if root.left is None:
                return root.right
            elif root.right is None:
                return root.left
            else:
                left_highest = find_highest(root.left)
                left_highest.right = root.right
                root = root.left
        else:
            if parent.left == curr:
                if curr.left is None:
                    parent.left = curr.right
                elif curr.right is None:
                    parent.left = curr.left
                else:
                    left_highest = find_highest(curr.left)
                    left_highest.right = curr.right
                    parent.left = curr.left
            else:
                if curr.left is None:
                    parent.right = curr.right
                elif curr.right is None:
                    parent.right = curr.left
                else:
                    left_highest = find_highest(curr.left)
                    left_highest.right = curr.right
                    parent.right = curr.left

        return root
