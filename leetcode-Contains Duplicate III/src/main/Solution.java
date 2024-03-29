package main;

import java.util.TreeSet;

public class Solution {
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(k < 1 || t < 0)
			return false;
		
		TreeSet<Integer> set = new TreeSet<>();
		for(int i = 0 ; i < nums.length; i++) {
			int n = nums[i];
			if(set.floor(n) != null && set.floor(n) + t >= n)
				return true;
			if(set.ceiling(n) != null && set.ceiling(n)-t <= n)
				return true;
			
			set.add(n);
			
			if(i >= k)
				set.remove(nums[i-k]);				
		}
		
		return false;
		
    }

	
	
	public static void main(String[] args) {
		
		int nums[] = {1,2};
		System.out.println(containsNearbyAlmostDuplicate(nums, 2, 1));
		
	}
}
