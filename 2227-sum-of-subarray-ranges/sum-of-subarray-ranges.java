class Solution {
    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMin(nums);
    }

    public static long sumSubarrayMax(int[] arr) {
        int[] pge = previousGreaterEqualElementLeft(arr);
        int[] nge = nextGreaterElementRight(arr);
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            sum = sum + left * right * arr[i];
        }
        return sum;
    }

    public static long sumSubarrayMin(int[] arr) {
        int[] pse = previousSmallerEqualElementLeft(arr);
        int[] nse = nextSmallerElementRight(arr);
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;
            sum = sum + left * right * arr[i];
        }
        return sum;
    }

    public static int[] nextSmallerElementRight(int[] nums) {
        int n = nums.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    public static int[] previousSmallerEqualElementLeft(int[] nums) {
        int n = nums.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    public static int[] nextGreaterElementRight(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }

    public static int[] previousGreaterEqualElementLeft(int[] nums) {
        int n = nums.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }
}