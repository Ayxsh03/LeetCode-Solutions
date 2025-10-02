class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            numBottles = numBottles - numExchange + 1; // exchange & drink
            ans++;
            numExchange++;
        }
        return ans;
    }
}