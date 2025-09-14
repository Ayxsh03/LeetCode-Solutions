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
        dfs(head);
        return head;
    }
    
    private Node dfs(Node temp) {
        if (temp == null) return null;
        // If this node has no next and no child → it's a tail
        if (temp.next == null && temp.child == null) return temp;
        
        Node nextNode = temp.next;
        Node child = temp.child;
        Node parent = temp;

        Node tail = null;

        // If child exists, flatten it first
        if (child != null) {
            Node childTail = dfs(child); // flatten the child list

            // Connect parent -> child
            parent.next = child;
            child.prev = parent;
            parent.child = null; // important: remove child pointer

            // Connect child's tail -> nextNode
            if (nextNode != null) {
                childTail.next = nextNode;
                nextNode.prev = childTail;
            }

            tail = childTail; // child's tail may become the new tail
        }

        // Continue flattening the rest (nextNode)
        if (nextNode != null) tail = dfs(nextNode);
        return tail != null ? tail : temp;
    }
}