class Solution {
    public int maxScore(int[] card, int k) {
        int n = card.length;
        int leftSum = 0, rightSum = 0;
        
        for (int i = 0; i < k; i++) leftSum += card[i];
        int maxSum = leftSum;
        int i = k - 1, j = n - 1;
        while(i >= 0){
            leftSum -= card[i];
            rightSum += card[j];
            i--; j--;
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }
}