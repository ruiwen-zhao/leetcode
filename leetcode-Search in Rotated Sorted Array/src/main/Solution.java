package main;

public class Solution {
	public static int search(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return -1;
        return binary(nums, 0, nums.length-1, target);
    }
	
	static int binary(int[] nums, int begin, int end , int target) {
		
		if(nums[(begin + end)/2] == target)
			return (begin + end)/2;
		
		if(begin > end)
			return -1;
		
		if(nums[(begin + end)/2] < nums[begin]) {		//latter half is sorted
			if(nums[(begin + end)/2] < target && target <= nums[end]) {
				return sortedBinary(nums, (begin+end)/2+1, end, target);
				
			}
				
			return binary(nums, begin, (begin+end)/2-1, target);	
		}
		else if(nums[(begin + end)/2] > nums[begin]){										//former half is sorted
			if(nums[(begin + end)/2] > target && target >= nums[begin])
				return sortedBinary(nums, begin, (begin+end)/2-1, target);
			else
				return binary(nums, (begin+end)/2+1, end, target);				
		}
		else {
			return binary(nums, begin+1, end, target);		
		}
	}
	
	static int sortedBinary(int[] nums, int begin, int end, int target) {
		
		if(begin > end)
			return -1;
		
		if(nums[(begin + end)/2] == target)
			return (begin + end)/2;
		else if(nums[(begin + end)/2] < target)
			return sortedBinary(nums, (begin+end)/2+1, end, target);
		else
			return sortedBinary(nums, begin, (begin+end)/2-1, target);
		
	}
	
	public static void main(String[] args) {
		int nums[] = {1,3,1,1,1};
		System.out.println(search(nums, 3));
	}
}
