class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0) return 0;
        int n = nums.length;
        int sum = 0;
        int right = 0, left = 0;
        int product = 1;
        while(right < n){
            product *= nums[right];
            while(left < right && product >= k){
                product /= nums[left];
                left++;
            }
            if(product < k) sum += right - left + 1;
            right++;
        }
        return sum;
    }
}