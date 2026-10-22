class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> number = new Stack<>();
        int  k = 0;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k*10 + (ch - '0');
            }
            else if(ch == '['){
                number.push(k);
                k = 0;
                str.push(new StringBuilder(Character.toString(ch)));
            }
            else if(ch == ']'){
                String sNew = "";
                StringBuilder sb = new StringBuilder();
                while (!str.peek().toString().equals("[")){
                    sNew = str.pop() + sNew;
                }
                str.pop();
                int n = number.pop();
                for(int i = 0; i<n; i++){
                    sb.append(sNew);
                }
                str.push(sb);
            }
            else{
                str.push(new StringBuilder(Character.toString(ch)));
            }
        }
        StringBuilder result = new StringBuilder();
        while(str.size() > 0){
            result.insert(0, str.pop());
        }
        return result.toString();
    }
}