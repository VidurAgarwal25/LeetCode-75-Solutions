/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode temp = slow.next;
        ListNode prev = null;
        ListNode curr = temp;
        while (curr != null) {
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        slow.next = prev; 
        
        temp = slow.next;
        int maxSum = 0;
        while (temp != null) {
            maxSum = Math.max(maxSum, head.val + temp.val);
            head = head.next;
            temp = temp.next;
        }
        
        return maxSum;
    }
}
