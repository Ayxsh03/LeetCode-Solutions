
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i); // O(1) lookup

        while (head != null && set.contains(head.val)){
            if(set.contains(head.val)) head = head.next;
        }

        ListNode prev = null;
        ListNode temp = head;

        while(temp != null){
            if(set.contains(temp.val)){
                prev.next = temp.next;
            }
            else prev = temp;
            temp = temp.next;
        }
        return head;
    }
}