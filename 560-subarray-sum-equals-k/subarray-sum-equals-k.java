class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //<prefixsum,count>
        int prefixsum=0, count=0;
        map.put(0,1); //empty subarray: sum=0,count=1
        for(int i=0; i<nums.length; i++){
            prefixsum += nums[i];
            if(map.containsKey(prefixsum - k)){
                count += map.get(prefixsum - k);
            }
            map.put(prefixsum, map.getOrDefault(prefixsum,0)+1);
        }
        return count;
    }
}