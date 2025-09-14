/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        List<Integer> ans = new ArrayList<>();
        dfs(head, ans);

        Node newHead = new Node(ans.get(0));
        Node temp = newHead;
        for (int i = 1; i < ans.size(); i++) {
            Node newNode = new Node(ans.get(i));
            newNode.prev = temp;
            temp.next = newNode;
            temp.child = null;
            temp = temp.next;
        }
        return newHead;
    }

    private void dfs(Node temp, List<Integer> ans) {
        if (temp == null) return;
        ans.add(temp.val);

        if (temp.child != null) dfs(temp.child, ans);
        dfs(temp.next, ans);
    }
}