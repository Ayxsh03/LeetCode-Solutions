class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums2.length == 0 || nums1.length == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while(!st.isEmpty() && st.peek() <= num) st.pop();
            if (st.isEmpty()) map.put(num, -1);
            else map.put(num, st.peek());
            st.push(num);
        }
        // Build answer for nums1
        int[] nge = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            nge[i] = map.get(nums1[i]);
        }
        
        return nge;
    }
}