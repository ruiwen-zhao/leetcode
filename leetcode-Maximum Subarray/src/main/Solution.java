package main;

public class Solution {
	public static int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
        return maxSubArray(nums, 0, nums.length-1);
    }
	
	static int maxSubArray(int[] nums, int begin, int end) {
		if(begin == end)
			return nums[begin];
		
		
		int mid = (begin + end)/2;
		int leftMax = maxSubArray(nums, begin, mid);
		int rightMax = maxSubArray(nums, mid+1, end);
		
		int midLeftMax = nums[mid];
		int total = nums[mid];
		for(int i = mid-1; i >= begin; i--) {
			total += nums[i];
			if(total > midLeftMax)
				midLeftMax = total;
		}
		
		int midRightMax = nums[mid+1];
		total = nums[mid+1];
		for(int i = mid+2; i <= end; i++) {
			total += nums[i];
			if(total > midRightMax)
				midRightMax = total;
		}
		int midMax = midLeftMax + midRightMax;
		
		int max = leftMax;
		if(rightMax > max)
			max = rightMax;
		if(midMax > max)
			max = midMax;
		
		return max;		
	}
	
	public static void main(String[] args) {
		
		
		int nums[] = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
}
