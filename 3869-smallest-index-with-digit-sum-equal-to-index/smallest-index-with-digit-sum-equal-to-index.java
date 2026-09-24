class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for(int i = 0; i<n; i++){
            int sum = i;
            int digitSum = 0;
            while(nums[i] > 0){
                digitSum += nums[i] % 10;
                nums[i] = nums[i]/10;
            }
            if(digitSum == sum){
                return i;
            }
        }
        return -1;
    }
}