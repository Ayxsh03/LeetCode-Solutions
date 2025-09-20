class Solution {
    public int sumSubarrayMins(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        // Fill PSE
        getPSE(arr, pse, n, st);
        st.clear();

        // Fill NSE
        getNSE(arr, nse, n, st);

        long sum = 0;
        long mod = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            sum = (sum + (left * right % mod) * arr[i] % mod) % mod;
        }

        return (int) sum;
    }

    public static void getPSE(int[] arr, int[] pse, int n, Stack<Integer> st) {
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {  // strictly >
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
    }

    public static void getNSE(int[] arr, int[] nse, int n, Stack<Integer> st) {
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) { // allow equal here
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
    }
}