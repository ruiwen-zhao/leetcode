package main;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	
	
	public static List<String> letterCombinations(String digits) {
		
		
		
		char [][]board = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
				{'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
		
		
        List<String> combinationList = new ArrayList<String>();
        if(digits == null || digits.length() == 0) {
			
			return combinationList;
			
		}
        backtrack(digits, 0, "", combinationList, board);
        return combinationList;
    }
	
	static void backtrack(String digits, int pos, String combination, List<String> combinationList, char[][] board) {
		if(pos == digits.length()) {
			combinationList.add(new String(combination));
			return;
		}
		
		for(int i = 0; i < board[digits.charAt(pos) - '2'].length; i++ ) {
			combination = combination + board[digits.charAt(pos) - '2'][i];
			backtrack(digits, pos+1, combination, combinationList, board);
			combination = combination.substring(0, combination.length()-1);
		}		
	}
	
	public static void main(String[] args) {
		System.out.print(letterCombinations(""));
	}
	
	
	
}
