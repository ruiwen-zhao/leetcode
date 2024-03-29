package main;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public static void solve(char[][] board) {
		if(board == null || board.length == 0)
			return;
		
		Queue<Integer> xIndex = new LinkedList<>();
		Queue<Integer> yIndex = new LinkedList<>();
		
        for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 'O') {
				xIndex.add(0);
				yIndex.add(i);
			}
			
			if (board[board.length-1][i] == 'O') {
				xIndex.add(board.length-1);
				yIndex.add(i);
			}
		}
        
        for (int i = 0; i < board.length; i++) {
			if (board[i][0] == 'O') {
				xIndex.add(i);
				yIndex.add(0);
			}
			
			if (board[i][board[0].length-1] == 'O') {
				xIndex.add(i);
				yIndex.add(board[0].length-1);
			}
		}
        
        while(!xIndex.isEmpty()) {
        	int x = xIndex.poll();
        	int y = yIndex.poll();
        	
        	board[x][y] = 'Y';
        	
        	if(x > 0 && board[x-1][y] == 'O') {
        		xIndex.add(x-1);
        		yIndex.add(y);
        	}
        	
        	if(x < board.length-1 && board[x+1][y] == 'O') {
        		xIndex.add(x+1);
        		yIndex.add(y);
        	}
        	
        	if(y > 0 && board[x][y-1] == 'O') {
        		xIndex.add(x);
        		yIndex.add(y-1);
        	}
        	
        	if(y < board[0].length-1 && board[x][y+1] == 'O') {
        		xIndex.add(x);
        		yIndex.add(y+1);
        	}
        }
        
        for(int i = 0 ; i < board.length; i++ ) {
        	for(int j = 0 ; j < board[0].length; j++) {
        		if(board[i][j] == 'O')
        			board[i][j] = 'X';
        		if(board[i][j] == 'Y')
        			board[i][j] = 'O';
        	}
        }
        
    }
	
	public static void main(String[] args) {
		char[][] board = {{'X', 'O', 'X', 'X'}, {'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X'}};
		solve(board);
		
		for(int i = 0 ; i < board.length; i++) {
			for(int j = 0 ; j < board[0].length; j++) {
				System.out.print(board[i][j]);
				
			}
			System.out.print("\n");
		}
	}
}
