/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    int pairSum(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head->next;
        while (fast != NULL && fast->next != NULL) {
            slow = slow->next;
            fast = fast->next->next;
        }
        ListNode* temp=slow->next;
        ListNode* prev=NULL;
        ListNode* curr=temp;
        while(curr!=NULL){
            ListNode* tempnext=curr->next;
            curr->next=prev;
            prev=curr;
            curr=tempnext;
        }
        slow->next=prev;
        temp=slow->next;
        int maxsum=0;
        while(temp!=NULL){
            maxsum=max(maxsum,head->val+temp->val);
            head=head->next;
            temp=temp->next;
        }
        return maxsum;
    }
};