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
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firstHalf = head;
        ListNode secondHalf = slow.next;
        secondHalf = reverse(secondHalf);

        int maxSum = Integer.MIN_VALUE;
        while(secondHalf != null) {
            int sum = firstHalf.val + secondHalf.val;
            maxSum = Math.max(sum, maxSum);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return maxSum;
    }

    public ListNode reverse(ListNode temp) {
        ListNode prev = null;
        ListNode next = temp;
        while(temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}