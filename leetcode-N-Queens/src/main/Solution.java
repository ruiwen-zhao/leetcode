package main;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static List<Integer> part;
	//public boolean[] rowContradict;
	public static boolean[] colContradict;
	public static boolean[] leftContradict;
	public static boolean[] rightContradict;
	public static List<List<Integer>> solutions;
	
	public static List<List<String>> solveNQueens(int n) {
		part = new ArrayList<Integer>();
		//rowContradict = new boolean[n];
		colContradict = new boolean[n];
		leftContradict = new boolean[2*n-1];
		rightContradict = new boolean[2*n-1];
		solutions = new ArrayList<List<Integer>>();
		
		backtrack(0, n);
		
		List<List<String>> outList = new ArrayList<List<String>>();
		
		for(List<Integer> list : solutions) {
			List<String> stringList = new ArrayList<>();
			for(Integer integer : list) {
				String string = "";
				for(int i = 0 ; i < integer; i++ )
					string = string + ".";
				string = string + "Q";
				for(int i = integer+1; i < n; i++ )
					string = string + ".";
				stringList.add(string);
			}
			outList.add(stringList);
		}
		
		return outList;
	}

	
	
	
	public static void backtrack(int row, int n) {
		if(row == n) {
			solutions.add(new ArrayList<Integer>(part));
			return;
		}
		
		for(int i = 0 ; i < n; i++) {
			if(colContradict[i] || leftContradict[n-1-row+i] || rightContradict[row+i])
				continue;
			part.add(i);
			colContradict[i] = true;
			leftContradict[n-1-row+i] = true;
			rightContradict[row+i] = true;
						
			backtrack(row+1, n);
			part.remove(part.size()-1);
			colContradict[i] = false;
			leftContradict[n-1-row+i] = false;
			rightContradict[row+i] = false;
		}
		
	}
	
	public static void main(String[] args) {
		List<List<String>> list = solveNQueens(4);
		
		System.out.print(list);
	}
}
