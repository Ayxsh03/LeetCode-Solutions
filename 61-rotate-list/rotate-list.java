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
        
        ListNode temp = head;
        int n = 1;
        while(temp.next != null){
            temp = temp.next;
            n++;
        }
        //Now temp will be on the tail
        temp.next = head; //Circular LL

        k = k % n;
        if(k == 0){
            temp.next = null; //break circle before returning
            return head;
        }

        temp = head;
        for(int i = 0; i < n - k - 1; i++){ //-1 so that temp stops at the tail
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null; //break circle before returning
        return newHead;
    }
}