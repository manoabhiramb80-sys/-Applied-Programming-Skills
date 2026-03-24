class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i = 0; i < n; i++){
            currSum = currSum + nums[i];
            maxSum = Math.max(maxSum, currSum);

             if(currSum < 0){
                currSum = 0;
            }
        }

        return maxSum;
    }
}