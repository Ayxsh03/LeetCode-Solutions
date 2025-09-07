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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null) return head;

        Stack<Integer> st = new Stack<>();
        ListNode temp = head, leftN = null, rightN = null;
        int count = 1;

        while(temp != null){
            if(count == left) leftN = temp;
            if(count == right) rightN = temp;

            if(count >= left && count <= right) st.push(temp.val);
            temp = temp.next;
            count++;
        }

        int len = right - left + 1;
        for(int i = 0; i < len; i++){
            leftN.val = st.pop();
            leftN = leftN.next;
        }
        
        return head;
    }
}