package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	public static List<String> generateParenthesis(int n) {
		List<String> solList = new ArrayList<>();
		backtrack(n, n, "", solList);
		return solList;
        
    }

	static void backtrack(String solution, Set<String> solList, int n,  int[] able ) {
		
		if(solution.length() == 2*n) {
			solList.add(new String(solution));
			return;
		}
		
		for(int i = 0 ; i < n; i++ ) {
			if(able[i] == 2)
				continue;
			if(able[i] == 0) {
				solution = solution + '(';
				able[i]++;
				backtrack(solution, solList, n, able);
				solution = solution.substring(0, solution.length()-1);
				able[i]--;
			}
			if(able[i] == 1) {
				solution = solution + ')';
				able[i]++;
				backtrack(solution, solList, n, able);
				solution = solution.substring(0, solution.length()-1);
				able[i]--;
			}
				
		}
	}
	
	
	
	static void backtrack(int left, int right, String solution, List<String> solList) {
		
		if(left == 0 && right == 0) {
			solList.add(new String(solution));
			return;
		}
		
		if(left > 0)
			backtrack(left-1, right, solution + '(', solList);
		if(right > 0 && left < right)
			backtrack(left, right-1, solution + ')', solList);
		
	}
	
	public static void main(String[] args) {
		System.out.println(generateParenthesis(6));
	}
}
