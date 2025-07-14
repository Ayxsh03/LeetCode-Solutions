class Solution {
    public int findKthPositive(int[] arr, int k) {
        ArrayList<Integer> missing = new ArrayList<>();
        int counter = 1;
        int i = 0;
        while(i < arr.length){
            if(arr[i] != counter){
                missing.add(counter);
                counter++;
                continue;
            }
            counter++;
            i++;
        }
        while(missing.size() < k) missing.add(counter++);
        return missing.get(k-1);
    }
}