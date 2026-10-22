class Solution {
    public String simplifyPath(String path) {
        String [] arr = path.split("/");
        Stack<String> st = new Stack<>();
        for(int i = 0; i<arr.length; i++){
            if(arr[i].equals("") || arr[i].equals(".")){
                continue;
            }
            else if (arr[i].equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
            else{
                st.push(arr[i]);
            }
        }
        StringBuilder sbN = new StringBuilder();
        for (String dir : st) {
            sbN.append("/").append(dir);
        }
        if (sbN.length() == 0) {
            return "/";
        }
        return sbN.toString();
    }
}