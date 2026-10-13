class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        parenthesis("",0,0,n,ans);
        return ans;
    }
    public void parenthesis(String s, int l, int r, int n , List<String> ans){
        if(l == n && r == n){
            if(s.length() != 0){
                ans.add(s);
                return;
            }
        }
        if(l < n){
            parenthesis(s+'(',l+1,r,n,ans);
        }
        if(r<l){
            parenthesis(s+')',l, r+1, n, ans);
        }
    }
}