class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for(int col = 0; col <= rowIndex; col++){ //0th->1 1st-> 2...3rd->4
            ans.add(nCr(rowIndex,col));
        }
        return ans;
    }

    public static int nCr(int n, int r) {
        long res = 1;
        if(r>n/2) r = n-r;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int)res;
    }
}