class Solution {
    public int myAtoi(String s) {
        String sb = s.trim();
        int n = sb.length();
        int result = 0;
        int sign = 1;
        int idx = 0;
        if(sb.length() == 0){
            return 0;
        }
        if(sb.charAt(0) == '+' || sb.charAt(0) == '-'){
            if(sb.charAt(idx) == '-'){
                sign = -1;
            }
            idx++;
        }
        for(int i = idx; i<n; i++){
            char ch = sb.charAt(i);
            if(Character.isDigit(ch)){
                int digit = ch - '0';
                if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && digit > 7)){
                    return (sign == 1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                result = result*10 + digit;
            }
            else {
                break;
            }
        }
        return result * sign;

    }
}