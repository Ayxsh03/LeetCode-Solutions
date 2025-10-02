class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            int newEmpty = numBottles - numExchange;
            ans += 1; // new exchanged
            numExchange++;
            numBottles = newEmpty + 1; //new exchanged empty
        }
        return ans;
    }
}