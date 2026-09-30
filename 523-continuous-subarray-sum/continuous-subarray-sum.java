class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for(int i = 1; i<n+1; i++){
            prefix[i] = prefix[i - 1] + nums[i-1];
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        map.put(prefix[0],new ArrayList<>());
        map.get(prefix[0]).add(0);
        for(int i = 1; i<n+1; i++){
            int rem = ((prefix[i] % k)+k)%k;
            if(map.containsKey(rem)){
                int len = i - map.get(rem).get(0);
                map.get(rem).add(i);
                if(len >= 2) return true;
            }
            else{
                map.put(rem, new ArrayList<>());
                map.get(rem).add(i);
            }
        }
        return false;
    }
}