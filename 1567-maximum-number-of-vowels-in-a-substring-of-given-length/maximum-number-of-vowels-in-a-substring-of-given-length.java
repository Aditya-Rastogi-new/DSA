class Solution {
    public boolean isEven(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int cnt = 0;
        for(int i = 0; i<k; i++){
            char ch = s.charAt(i);
            if(isEven(ch)){
                cnt++;
            }
        }
        int maxcnt = cnt;
        for(int i = k; i<s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(i-k);
            if(isEven(ch1) && !isEven(ch2)){
                cnt++;
            }
            else if(!isEven(ch1) && isEven(ch2)){
                cnt--;
            }
            maxcnt = Math.max(maxcnt, cnt);
        }
        return maxcnt;
    }
}