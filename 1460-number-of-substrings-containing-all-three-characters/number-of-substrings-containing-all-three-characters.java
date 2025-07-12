class Solution {
    public int numberOfSubstrings(String s) {
        int[] seen={-1,-1,-1};
        int count = 0;
        for(int i=0; i<s.length(); i++){
            seen[s.charAt(i)-'a']=i; //Update the corresponding index in seen
//Subtracting 'a' from the character ensures that 'a' maps to 0, b' to 1, and 'c' to 2.
            if(seen[0]!=-1 && seen[1]!=-1 && seen[2]!=-1){
               count = count + 1 + Math.min(seen[0], Math.min(seen[1], seen[2]));
            }
        }
        return count;
    }
}