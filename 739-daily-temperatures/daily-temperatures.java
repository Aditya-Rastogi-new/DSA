class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        Stack<Integer> st = new Stack<>();
        int [] ans = new int[n];
        for(int i = 0; i<n; i++){
            while(st.size() > 0 && temp[i] > temp[st.peek()]){
                int previdx = st.pop();
                ans[previdx] = i - previdx;
            }
            st.push(i);
        }
        return ans;
    }
}