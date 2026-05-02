class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        int[] state = {0,0,1,-1,-1,1,1,-1,0,1};

        for (int i = 1; i <= n; i++) {
            int num = i;
            boolean bad = false;
            boolean changed = false;

            while (num > 0) {
                int digit = num % 10;
                if (state[digit] == -1) {
                    bad = true;
                    break;
                }
                if (state[digit] == 1) changed = true;
                num /= 10;
            }
            if (!bad && changed) count++;
        }
        return count;
    }
}