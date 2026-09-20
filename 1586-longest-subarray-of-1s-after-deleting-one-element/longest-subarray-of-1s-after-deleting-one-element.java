class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, right = 0;
        int maxlen = 0;
        int zero = 0;
        int n = nums.length;
        while(right < n){
            if(nums[right] == 0) zero++;
            while(zero > 1){
                if(nums[left] == 0) zero--;
                left++;
            }
            if(zero<=1){
                maxlen = Math.max(maxlen, right - left);
            }
            right++;
        }
        return maxlen;
    }
}