class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        String ans = "";

        int fact = 1; //calculate (n-1)!
        for(int i = 1; i < n; i++){
            fact = fact * i;
            nums.add(i);
        }
        nums.add(n);
        k--; //0 based

        while(true){
            ans = ans + nums.get(k / fact);
            nums.remove(k / fact);
            if(nums.size() == 0) break;
            k = k % fact;
            fact = fact / nums.size();
        }
        return ans;
    }

}