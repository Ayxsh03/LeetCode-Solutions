class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        int[] map = {0,1,2,-1,-1,5,6,-1,8,9};

        for (int i = 1; i <= n; i++) {
            int num = i;
            boolean bad = false;
            boolean changed = false;

            while (num > 0) {
                int digit = num % 10;
                if (map[digit] == -1) { // invalid
                    bad = true;
                    break;
                }
                if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                    changed = true;
                }
                num /= 10;
            }
            if (!bad && changed) count++;
        }
        return count;
    }
}