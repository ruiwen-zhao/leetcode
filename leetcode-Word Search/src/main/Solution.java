package main;

public class Solution {
	
	public static boolean found = false;
	public static boolean used[][];
	
	public static boolean exist(char[][] board, String word) {
        used = new boolean[board.length][board[0].length];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				int[] pos = {i,j};
				backtrack(word, new String(""), board, pos);
				if(found)
					return true;
			}
		}
		
		
		return found;
    }
	
	
	
	public static void backtrack(String word, String part, char[][] board, int[] pos ) {
		
		if(word.charAt(part.length()) == board[pos[0]][pos[1]] && !used[pos[0]][pos[1]]) {
			used[pos[0]][pos[1]] = true;
			part = part + board[pos[0]][pos[1]];
		}
		else {
		
	
			return;
		}
				
		if(part.equals(word)) {
			found = true;
			return;
		}
			
		
		//up
		if(pos[0] != 0) {
			pos[0]--;
			//used[pos[0]][pos[1]] = true;
			backtrack(word, part, board, pos);
			//used[pos[0]][pos[1]] = false;
			//part = part.substring(0, part.length()-1);
			pos[0]++;
		}
		
		if(found)
			return;
		
		//down
		if(pos[0] != board.length-1 ) {
			pos[0]++;
			//used[pos[0]][pos[1]] = true;
			backtrack(word, part, board, pos);
			//used[pos[0]][pos[1]] = false;
			//part = part.substring(0, part.length()-1);
			pos[0]--;
		}
		
		if(found)
			return;
		
		//left
		if(pos[1] != 0 ) {
			pos[1]--;
			//used[pos[0]][pos[1]] = true;
			backtrack(word, part, board, pos);
			//used[pos[0]][pos[1]] = false;
			//part = part.substring(0, part.length()-1);
			pos[1]++;
		}
		
		if(found)
			return;
		
		//right
		if(pos[1] != board[0].length-1) {
			pos[1]++;
			//used[pos[0]][pos[1]] = true;
			backtrack(word, part, board, pos);
			//used[pos[0]][pos[1]] = false;
			//part = part.substring(0, part.length()-1);
			pos[1]--;
		}
		
		//not right
		used[pos[0]][pos[1]] = false;
		return; 
	}

	
	public static void main(String[] args) {
		char board[][] = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
		String word = "AAB";
		System.out.println(exist(board, word));
		//System.out.println(word.substring(0,word.length()-1));
	}
}
