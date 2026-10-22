class Solution {
    public int[] asteroidCollision(int[] a) {
        int n = a.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            if(st.size() > 0 && st.peek() > 0 && a[i] < 0){
                while(st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(a[i])){
                    st.pop();
                }
                if(st.size() > 0 && st.peek() == Math.abs(a[i]) && st.peek() > 0){
                    st.pop();
                    continue;
                }
                if(st.size() > 0 && st.peek() > Math.abs(a[i]) && st.peek() > 0){
                    continue;
                }
                // if(st.size() > 0 && st.peek() > 0) continue;
            }
            st.push(a[i]);
        }
        int m = st.size();
        int[] ans = new int[m];
        for(int i = m-1; i>=0 ;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}