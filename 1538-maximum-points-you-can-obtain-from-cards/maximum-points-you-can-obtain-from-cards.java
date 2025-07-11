class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0;
        int n = cardPoints.length;

        int total = 0;
        for(int i = 0; i < n; i++) total += cardPoints[i];

        int l = 0, r = n - k;
        while(r <= n){
            int sum = 0;
            for(int i = l; i < r; i++) sum += cardPoints[i];
            max = Math.max(max, total - sum);
            l++; r++;
        }
        return max;
    }
}