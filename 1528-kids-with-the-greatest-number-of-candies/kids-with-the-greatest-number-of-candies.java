class Solution {
    public List<Boolean> kidsWithCandies(int[] nums, int k) {
        List<Boolean> list = new ArrayList<>();
        int maxnum = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            maxnum = Math.max(maxnum, nums[i]);
        }
        for(int i = 0; i<nums.length; i++){
            if(nums[i]+k >= maxnum){
                list.add(true);
            } else{
                list.add(false);
            }
        }
        return list;
    }
}