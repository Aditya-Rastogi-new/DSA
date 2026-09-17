class Solution {
    public int maxScore(int[] nums, int k) {
        int lSum = 0, rSum = 0;
        int n = nums.length;
        for(int i = 0; i<k; i++){
            lSum += nums[i];
        }
        int maxPoint = lSum;
        for(int i = 1; i<=k; i++){
            lSum -= nums[k-i];
            rSum += nums[n-i];
            maxPoint = Math.max(maxPoint,lSum + rSum);
        }
        return maxPoint;
    }
}