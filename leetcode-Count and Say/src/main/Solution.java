package main;

public class Solution {
	public static String countAndSay(int n) {
        String start = "1";
        String temp = "";
        for(int i= 1; i < n; i++) {
        	int last = -1;
        	for(int j = 0; j < start.length(); j++) {
        		if(j > 0 && start.charAt(j) != start.charAt(j-1)) {
        			temp = temp + (char)('0'+ j-1-last);
        			temp = temp + start.charAt(j-1);
        			last = j-1;
        		}
        		if(j == start.length()-1) {
        			temp = temp + (char)('0'+ j-last);
        			temp = temp + start.charAt(j);
        		}
        		
        		
        		
        	}
        	start = temp;
        	temp = "";
        }
        
        return start;
    }
	
	public static void main(String[] args) {
		System.out.println(countAndSay(6));
	}
}
