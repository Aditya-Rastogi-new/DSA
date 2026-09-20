class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for(int i = 0; i<s.length(); i++){
            int n1 = 26 - (s.charAt(i) - 'a');
            int n2 = i + 1;
            ans += n1*n2;
        }
        return ans;
    }
}