class StockSpanner {
    Stack<Pair<Integer,Integer>> st=new Stack<>();
    int index=-1;
    public StockSpanner() {
        index=-1;
        st.clear();
    }
    public int next(int price) {
        index++;
        while(!st.isEmpty() && st.peek().getKey() <= price){
            st.pop();
        }
        int ans= index - (st.isEmpty() ? -1 : st.peek().getValue());
        st.push(new Pair<>(price,index));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */