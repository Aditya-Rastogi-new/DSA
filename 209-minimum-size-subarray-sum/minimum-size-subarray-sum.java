class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        int minlen = n + 1;
        int sum = 0;
        while(right < n){
            sum += nums[right];
            while(sum >= target){
                minlen = Math.min(right - left + 1 , minlen);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return (minlen == n+1)?0:minlen;
    }
}