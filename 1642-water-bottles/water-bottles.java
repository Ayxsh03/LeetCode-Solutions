class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            int remainder = numBottles % numExchange;
            numBottles = numBottles/numExchange;
            ans = ans + numBottles;
            numBottles = numBottles + remainder;
        }
        return ans;
    }
}