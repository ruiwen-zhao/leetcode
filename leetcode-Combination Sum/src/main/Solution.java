package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	
	
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		if(candidates == null || candidates.length == 0)
			return result;
		
		Arrays.sort(candidates);
		backtrack(target, candidates, new ArrayList<Integer>(), result, 0);
        return result;
    }
	
	static void backtrack(int target, int[] candidates, ArrayList<Integer> current, ArrayList<List<Integer>> result, int pos) {
		if(target == 0) {
			result.add(new ArrayList<Integer>(current));
			return;
		}
		
		for(int i = pos; i < candidates.length; i++) {
			if(candidates[i] > target)					//this coin is too large
				return;
			
			current.add(candidates[i]);
			backtrack(target-candidates[i], candidates, current, result, i);
			current.remove(current.size()-1);
		}
		
	}
	
	public static void main(String[] args) {
		int can[] = {2,3,6,7};
		System.out.println(combinationSum(can, 7));
	}
	
	
	
	
}
