package main;

public class Solution {
	
	public static int romanToInt(String s) {
        int out = 0;
        for(int i = 0 ; i < s.length(); i++) {
        	if(s.charAt(i) == 'M') {
        		if(i == 0 || i > 0 && s.charAt(i-1) != 'C')
        			out += 1000;
        		if(i > 0 && s.charAt(i-1) == 'C')
        			out += 900;
        	}
        	
        	if(s.charAt(i) == 'D') {
        		if(i == 0 || i > 0 && s.charAt(i-1) != 'C')
        			out += 500;
        		if(i > 0 && s.charAt(i-1) == 'C')
        			out += 400;
        		
        	}
        		
        	
        	if(s.charAt(i) == 'C') {
        		if((i == s.length()-1 || s.charAt(i+1) != 'M' && s.charAt(i+1) != 'D') && (i == 0 || s.charAt(i-1) != 'X'))
        			out += 100;
        		if(i > 0 && s.charAt(i-1) == 'X')
        			out += 90;        		
        	}
        	
        	if(s.charAt(i) == 'L') {
        		if(i == 0 || i > 0 && s.charAt(i-1) != 'X')
        			out += 50;
        		if(i > 0 && s.charAt(i-1) == 'X')
        			out += 40;
        	}
        	
        	if(s.charAt(i) == 'X') {
        		if((i == s.length()-1 || s.charAt(i+1) != 'L' && s.charAt(i+1) != 'C') && (i == 0 || s.charAt(i-1) != 'I'))
        			out += 10;
        		if(i > 0 && s.charAt(i-1) == 'I')
        			out += 9;        		
        	}
        	
        	if(s.charAt(i) == 'V') {
        		if(i == 0 || i > 0 && s.charAt(i-1) != 'I')
        			out += 5;
        		if(i > 0 && s.charAt(i-1) == 'I')
        			out += 4;
        	}
        	
        	if(s.charAt(i) == 'I') {
        		if(i == s.length()-1 || s.charAt(i+1) != 'V' && s.charAt(i+1) != 'X') 
        			out += 1;        		
        	}
        		
        
        }
        return out;	
    }
	
	public static void main(String[] args) {
		System.out.print(romanToInt("MDCCCLXXX"));
	}
}
