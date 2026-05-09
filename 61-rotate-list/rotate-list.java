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
        if(k == 0) return head;
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        int n = 0;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        k = k % n;
        if(k == 0) return head;
        temp = head;
        for(int i = 0; i < n - k - 1; i++){
            temp = temp.next;
        }
        ListNode newHead = temp.next;
        temp.next = null;
        ListNode newTemp = newHead;
        while(newTemp.next != null){
            newTemp = newTemp.next;
        }
        newTemp.next = head;
        return newHead;
    }
}