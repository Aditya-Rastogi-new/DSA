class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int freq = 0;
        for(int i = 0; i<arr.length; i++){
            set.add(arr[i]);
            if(arr[i] == 0){
                freq++;
            }
        }
        if(freq >= 2) return true;
        for(int ele : set){
            if(ele!=0 && set.contains(ele*2)) return true;
        }
        
        return false;
    }
}