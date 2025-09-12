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
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) return head;
        
        ListNode fast = head, slow = head;
        int n = lengthLL(head);
        k = k % n;
        if(k == 0) return head;

        for(int i = 0; i < k; i++) fast = fast.next;

        while(fast.next != null){
            fast = fast.next; 
            slow = slow.next;
        }
        
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }

    public int lengthLL(ListNode head){
        int cnt = 0;
        ListNode temp=head;
        while(temp!=null){
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }
}