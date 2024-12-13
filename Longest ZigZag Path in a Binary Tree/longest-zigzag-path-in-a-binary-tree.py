# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution(object):
    
    def longestPath(self, r, dir, currlen, maxPath):
        if not r:
            return
        
        maxPath[0] = max(maxPath[0], currlen)
        
        self.longestPath(r.left, 'l', 1 if dir == 'l' else currlen + 1, maxPath)
        
        self.longestPath(r.right, 'r', 1 if dir == 'r' else currlen + 1, maxPath)

    def longestZigZag(self, root):
        maxPath = [0]
        self.longestPath(root, 'l', 0, maxPath)
        self.longestPath(root, 'r', 0, maxPath)
        return maxPath[0]
