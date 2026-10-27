class Solution {
    int[] ans;
    public int[] sortArray(int[] nums) {
        ans = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }
    void sort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            sort(nums, left, mid);
            sort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int k = left;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                ans[k++] = nums[i++];
            } else {
                ans[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            ans[k++] = nums[i++];
        }
        while (j <= right) {
            ans[k++] = nums[j++];
        }
        for (int x = left; x <= right; x++) {
            nums[x] = ans[x];
        }
    }
}
