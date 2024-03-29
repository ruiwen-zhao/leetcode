package main;

public class Solution {
	public static int minDistance(String word1, String word2) {
        int min[][] = new int[word1.length()+1][word2.length()+1];
        for(int i = 0 ; i <= word1.length(); i++)
        	min[i][0] = i;
        for(int i = 0; i <= word2.length(); i++)
        	min[0][i] = i;
        
        for(int i = 1 ; i <= word1.length(); i++) {
        	for(int j = 1 ; j <= word2.length(); j++) {
        		
        		if(word1.charAt(i-1) == word2.charAt(j-1))
        			min[i][j] = min3(min[i-1][j]+1, min[i][j-1]+1, min[i-1][j-1]);
        		else
        			min[i][j] = min3(min[i-1][j]+1, min[i][j-1]+1, min[i-1][j-1]+1);
        	}
        }
        
        return min[word1.length()][word2.length()];
    }
	
	static int min3(int a, int b, int c) {
		int min =a;
		min = b < min ? b : min;
		min = c < min ? c : min;
		return min;
	}
	
	public static void main(String[] args) {
		System.out.println(minDistance("", "execution"));
	}
}
