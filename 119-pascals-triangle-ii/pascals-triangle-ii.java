class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> arr = new ArrayList<>();
        long ans=1;
        arr.add(1);
        for(int col = 0; col < rowIndex; col++){ //0th->1 1st-> 2...3rd->4
            ans = ans*(rowIndex-col);
            ans = ans/(col+1);
            arr.add((int)ans);
        }
        return arr;
    }
}