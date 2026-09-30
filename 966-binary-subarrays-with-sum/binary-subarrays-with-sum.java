class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for(int i = 1; i<n+1 ;i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(prefix[0],1);
        int ans = 0;
        for(int i = 1; i<n+1; i++){
            if(map.containsKey(prefix[i] - k)) ans += map.get(prefix[i] - k);
            map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        }
        return ans;
    }
}