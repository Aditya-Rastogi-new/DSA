class Solution {
    public boolean isSimilar(char top, char ch){
        if(top == '(' && ch == ')') return true;
        if(top == '{' && ch == '}') return true;
        if(top == '[' && ch == ']') return true;
        return false;
    }
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{
                if(st.size() == 0) return false;
                char top = st.peek();
                if(isSimilar(top, ch)){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(st.size() == 0) return true;
        return false;
    }
}