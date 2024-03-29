package main;

import java.util.Arrays;

public class Solution {
	public static void nextPermutation(int[] nums) {
		if(nums.length <= 1)
			return;
		int begin = -1;
        for(int i = nums.length-2; i >= 0; i--) {
        	if(nums[i] < nums[i+1]) {
        		begin = i;
        		break;
        	}        	
        }
        
        if(begin == -1) {
        	Arrays.sort(nums);
        	return;
        }
        
        int temp = nums[begin];
        int minIndex = -1;
        int min = 999999;
        for(int i = begin+1; i < nums.length; i++) {
        	if(nums[i] > nums[begin] && nums[i] < min) {
        		minIndex = i;
        		min = nums[i];
        		
        	}
        }
        
        nums[begin] = min;
        nums[minIndex] = temp;
        Arrays.sort(nums, begin+1, nums.length);
        
    }
	
	public static void main(String[] args) {
		int nums[] = {1,3,2};
		nextPermutation(nums);
		for(int num : nums)
			System.out.print(num);
	}
}
