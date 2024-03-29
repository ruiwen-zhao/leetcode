package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		
		HashSet<List<Integer>> result = new HashSet<List<Integer>>();
		if(candidates == null || candidates.length == 0)
			return new ArrayList<List<Integer>>();
		
		Arrays.sort(candidates);
		backtrack(target, candidates, new ArrayList<Integer>(), result, 0);
        return new ArrayList<List<Integer>>(result);
    }
	
	static void backtrack(int target, int[] candidates, ArrayList<Integer> current, HashSet<List<Integer>> result, int pos) {
		if(target == 0) {
			result.add(new ArrayList<Integer>(current));
			return;
		}
		
		for(int i = pos; i < candidates.length; i++) {
			if(candidates[i] > target)					//this coin is too large
				return;
			
			current.add(candidates[i]);
			backtrack(target-candidates[i], candidates, current, result, i+1);
			current.remove(current.size()-1);
		}
		
	}
	
	public static void main(String[] args) {
		int can[] = {10,1,2,7,6,1,5};
		System.out.println(combinationSum2(can, 8));
	}
	
	

}
