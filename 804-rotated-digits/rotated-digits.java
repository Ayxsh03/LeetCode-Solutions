class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        Set<Integer> badset = new HashSet<>(Arrays.asList(3, 4, 7));
        Set<Integer> goodset = new HashSet<>(Arrays.asList(2, 5, 6, 9));
        for(int i = 1; i <= n; i++){
            int num = i;
            boolean bad = false;
            boolean change = false;
            while(num > 0){
                int last = num % 10;
                if(badset.contains(last)) bad = true;
                if(goodset.contains(last)) change = true;
                num = num/10;
            }
            if(!bad && change) count++;
        }
        return count;
    }
}