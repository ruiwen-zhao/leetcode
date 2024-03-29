package main;

public class Solution {
	public static String longestPalindrome(String s) {
        int maxLength = 0, maxIndex = -1;
        
        for(int i = 0; i < 2*s.length()-1; i++) {
        	
        	if(i % 2 == 0) {
        		int length = 1;
        		int l = i/2-1, r = i/2+1;
        		while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
        			length += 2;
        			l--;
        			r++;       			
        		}
        		if(length > maxLength) {
        			maxLength = length;
        			maxIndex = i;
        		}
        		
        	}
        	
        	else {
        		int length = 0;
        		int l = (i-1)/2, r = (i+1)/2;
        		while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
        			length += 2;
        			l--;
        			r++;       			
        		}
        		if(length > maxLength) {
        			maxLength = length;
        			maxIndex = i;
        		}       		
        	}        	
        }
        
        
        if(maxIndex % 2 == 0)
        	return s.substring(maxIndex/2-(maxLength-1)/2, maxIndex/2+(maxLength-1)/2+1);
        
        else
        	return s.substring((maxIndex+1)/2-maxLength/2, (maxIndex+1)/2+maxLength/2);
        
    }

	
	public static void main(String[] args) {
		System.out.println(longestPalindrome(""));
	}
}
