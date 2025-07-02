class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length==1) return 1;
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxLen=0;
        int l=0;
        for(int r=0; r<fruits.length; r++){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            while(map.size() >2){
                map.put(fruits[l],map.get(fruits[l]) - 1);
                if(map.get(fruits[l])==0) map.remove(fruits[l]);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
}