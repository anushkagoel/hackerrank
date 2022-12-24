package com.demo;

public class HouseRobber {

    public static void main(String args[]) {
        HouseRobber robber = new HouseRobber();
        int[] nums = {2,1,1,2};
        robber.rob(nums);
    }

    public int rob(int[] nums) {
        int prev=0, last=0;
        for (int curr : nums) {
            prev = last;
            last = Math.max(prev + curr, last);

        }
        return last;
    }

    private int maxSum(int[] nums, int index) {
        int n = nums.length;
        int max= 0;
        if(index >= n) return 0;
        for(int j = index+1; j < n; j++) {
            max = Math.max(max, maxSum(nums, j));
        }
        return Math.max(max, max+nums[index]);
    }
}
