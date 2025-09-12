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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1), temp = head;
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        while(temp != null){
            ListNode kthNode = getKth(prevGroupEnd, k);
            if (kthNode == null) break;

            ListNode nextNode = kthNode.next; 
            kthNode.next = null;  

            ListNode groupStart = prevGroupEnd.next;
            ListNode newHead = reverseLL(groupStart);

            prevGroupEnd.next = newHead;
            prevGroupEnd = groupStart;

            groupStart.next = nextNode;
            temp = nextNode;
        }
        return dummy.next;
    }
    private ListNode getKth(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }

    public ListNode reverseLL(ListNode head){
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}