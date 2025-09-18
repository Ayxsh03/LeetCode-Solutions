class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] NGE = new int[nums1.length];
        Arrays.fill(NGE, -1);  // O(n2)

        for (int i = 0; i < nums1.length; i++) { // O(n2)
            //index of n2[i] in n1
            int index = -1;
            for (int k = 0; k < nums2.length; k++) { // O(n1)
                if (nums2[k] == nums1[i]) {
                    index = k;
                    break;
                }
            }

            //next greater element to the right in n1
            for (int j = index + 1; j < nums2.length; j++) { // O(n1)
                if (nums2[j] > nums2[index]) {
                    NGE[i] = nums2[j];
                    break;
                }
            }
        }
        return NGE;
    }
}