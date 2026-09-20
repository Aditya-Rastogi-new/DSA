class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int zero = 0;
        int maxlen = 0;
        int  n = nums.length;
        while(right < n){
            if(nums[right] == 0){
                zero++;
            }
            while(zero>k){
                if(nums[left] == 0) zero--;
                left++;
            }
            if(zero <= k){
                maxlen = Math.max(maxlen, right - left + 1);
            }
            right++;
        }
        return maxlen;
    }
}