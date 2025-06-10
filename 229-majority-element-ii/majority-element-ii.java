class Solution {
    public List<Integer> majorityElement(int[] nums) { 
        int count1 = 0, count2 = 0;
        int element1 = Integer.MIN_VALUE, element2 = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(count1 == 0 && element2 != nums[i]){
                count1 = 1;
                element1 = nums[i];
            } else if(count2 == 0 && element1 != nums[i]){
                count2 = 1;
                element2 = nums[i];
            } else if(element1 == nums[i]) count1++;
            else if(element2 == nums[i]) count2++;
            else{
                count1--;
                count2--;
            }
        }
        int a = 0, b = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == element1) a++;
            if(nums[i] == element2) b++;
        }
        int mini = nums.length/3 + 1;
        List<Integer> ans = new ArrayList<Integer>();
        if(a >= mini) ans.add(element1);
        if(b >= mini) ans.add(element2);

        return ans;
    }
}