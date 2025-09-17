class MinStack {
    Stack<Pair> st = new Stack<>();

    public void push(int x) {
        if (st.isEmpty()) st.push(new Pair(x, x)); // first element, min = x
        else {
            int min = Math.min(x, st.peek().value);
            st.push(new Pair(x, min));
        }
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().key;
    }

    public int getMin() {
        return st.peek().value;
    }
}
class Pair{
    int key;
    int value;

    Pair(int key ,int value){
        this.key = key;
        this.value = value;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */