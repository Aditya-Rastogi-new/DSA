class Solution {
    public int[][] flipAndInvertImage(int[][] nums) {
        int n = nums.length;
        for(int i = 0; i<n; i++){
            int left = 0, right = n -1;
            while(left < right){
                int temp = nums[i][left];
                nums[i][left] = nums[i][right];
                nums[i][right] = temp;
                left++;
                right--;
            }
            for(int j = 0; j<n; j++){
                nums[i][j] ^= 1;
            }
        }
        return nums;
    }
}