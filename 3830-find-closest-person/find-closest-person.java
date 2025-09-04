class Solution {
    public int findClosest(int x, int y, int z) {
        int abs1 = Math.abs(x - z), abs2 = Math.abs(y - z);
        if(abs1 == abs2) return 0;
        if(abs1 < abs2) return 1;
        return 2;
    }
}