# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution(object):
    def pairSum(self, head):
        """
        :type head: ListNode
        :rtype: int
        """
        slow = head
        fast = head.next
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next
        
        temp = slow.next
        prev = None
        while temp is not None:
            temp_next = temp.next
            temp.next = prev
            prev = temp
            temp = temp_next
        slow.next = prev  
        
        temp = slow.next
        max_sum = 0
        while temp is not None:
            max_sum = max(max_sum, head.val + temp.val)
            head = head.next
            temp = temp.next
        
        return max_sum
