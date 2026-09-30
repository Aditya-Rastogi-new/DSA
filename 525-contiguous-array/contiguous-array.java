class Solution {
    public int findMaxLength(int[] nums) {
        int [] prefix = new int[nums.length + 1];
        prefix[0] = 0;
        int maxlen = 0;
        int len = 0, n = nums.length;
        for(int i = 1; i<n+1; i++){
            if(nums[i - 1] == 0){
                prefix[i] = prefix[i-1] -1;
            }
            else{
                prefix[i] = prefix[i-1] +1;
            }
        }
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        map.put(prefix[0],new ArrayList<>());
        map.get(prefix[0]).add(0);
        for(int i = 1; i<n+1; i++){
            if(map.containsKey(prefix[i])){
                len = i - map.get(prefix[i]).get(0);
                maxlen = Math.max(len, maxlen);
                map.get(prefix[i]).add(i);
            }
            else{
                map.put(prefix[i],new ArrayList<>());
                map.get(prefix[i]).add(i);
            }
            
        }
        return maxlen;
    }
}