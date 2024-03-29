package main;

public class Solution {
	public static int trap(int[] height) {
		
		if(height == null || height.length == 0)
			return 0;
		
		int total = 0;
		int max = height[0];
		int leftMax[] = new int[height.length];
		int rightMax[] = new int[height.length];
		for(int i = 1 ; i < height.length; i++ ) {
			if(max > height[i]) {
				leftMax[i] = max;
			}
			else {
				leftMax[i] = height[i];
				max = height[i];
			}
				
		}
			
	
		max = height[height.length-1];
		for(int i = height.length-1; i >= 0; i--) {
			if(max > height[i]) {
				rightMax[i] = max;
			}
			else {
				rightMax[i] = height[i];
				max = height[i];
			}
		}
			
		for(int i = 1; i < height.length; i++)
			total += (leftMax[i] < rightMax[i] ? leftMax[i] : rightMax[i]) - height[i];
		
		return total;
			
    }
	
	public static void main(String[] args) {
		int nums[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(nums));
	}
}
