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

        if(head == null || head.next == null || k == 0) return head;
        int n = 1;
        ListNode tail = head;

        // find length and tail
        while(tail.next != null){
            tail = tail.next;
            n++;
        }
        k = k % n;
        if(k == 0) return head;

        // make circular
        tail.next = head;

        // move to new tail
        ListNode newTail = head;
        for(int i = 0; i < n - k - 1; i++){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        // break circle
        newTail.next = null;
        return newHead;
    }
}