class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int ast : asteroids) {
            boolean destroyed = false;
            // collision only if stack top > 0 and current < 0
            while (!st.isEmpty() && ast < 0 && st.peek() > 0) {
                if (Math.abs(ast) > st.peek()) {
                    st.pop();
                    continue; // keep checking
                } else if (Math.abs(ast) == st.peek()) {
                    st.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed) st.push(ast);
        }
        int ans[] = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}