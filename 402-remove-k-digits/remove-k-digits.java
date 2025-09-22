class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        Stack<Character> st = new Stack<>();
        for(int i=0; i < num.length(); i++){
            char x = num.charAt(i); 
            while(!st.isEmpty() && k > 0 && (st.peek() - '0' > x -'0')){
                st.pop();
                k--;
            }
            st.push(x);
        } 
        while(k > 0){
            st.pop();
            k--;
        }
        if(st.isEmpty()) return "0";

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());
        sb.reverse();
        
        //remove all the 0 at the head
        while(sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }
}