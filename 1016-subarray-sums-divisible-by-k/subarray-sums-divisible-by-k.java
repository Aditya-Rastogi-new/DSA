class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n+1];
        prefix[0] = 0;
        for(int i = 1; i <n+1;i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(prefix[0],1);
        int ans = 0;
        for(int i = 1; i<n+1; i++){
            int rem = ((prefix[i]%k)+k)%k;
            if(map.containsKey(rem)) ans += map.get(rem);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return ans;
    }
}