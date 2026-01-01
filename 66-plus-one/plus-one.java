class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                // If we incremented a non-9, no carry propagates further. 
                return digits;
            }
            // If it was 9, it becomes 0 and the loop continues
            digits[i] = 0;
        }

        // If the loop finishes, it means the number was something like 9, 99, or 999.
        // We need a new array: [1, 0, 0, ...]
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        
        return newNumber;
    }
}