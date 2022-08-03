package com.demo;

public class FirstAndLast {
    public static void main(String args[]) {
        searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
    }
    public static int[] searchRange(int[] nums, int target) {
        int low=0, high = nums.length;
        boolean flag = false;
        int mid = -1;
        while(low< high) {
            mid = (low+high) /2;
            if(nums[mid] == target) {
                flag = true;
                break;
            }
            if(nums[mid] <= target) {
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        if(flag) {
            //linerly search
            int start =mid;
            int last = mid;
            while(last < nums.length && nums[last] == target) {
                last++;
            }
            while(start >=0 && nums[start] == target) {
                start--;
            }
            return new int[]{start + 1, last - 1};
        } else{
            return new int[]{-1, -1};
        }
    }
}
