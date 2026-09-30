class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int[] prefix = new int[n+1];
        prefix[0] = 0;
        for(int i = 1; i<n+1; i++){
            if(nums[i - 1]%2 == 0){
                prefix[i] = prefix[i-1];
            }
            else{
                prefix[i] = prefix[i-1] + 1;
            }
            
        }
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n+1; i++){
            if(map.containsKey(prefix[i] - k)) ans += map.get(prefix[i] - k);
            map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        }
        return ans;
    }
}