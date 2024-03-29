package main;

public class Solution {
	public static int numDecodings(String s) {
		if(s == null || s.length() == 0 )
			return 0;
		
		return help(s);
    }
	
	static int help(String s) {
		if(s == null || s.length() == 0 ) {
			return 1;
		}
		if(s.length() == 1) {
			if(s.charAt(0) == '0')
				return 0;
			return 1;
		}
		int left = help(s.substring(0, s.length()/2));
		int right = help(s.substring(s.length()/2));
		int a = s.charAt(s.length()/2-1) - '0';
		int b = s.charAt(s.length()/2) - '0';
		int sum = a*10 + b;
		int middle = 0;
		if(sum <= 26 && sum >= 10 || sum < 10 && a > 0)
			middle = help(s.substring(0, s.length()/2-1))*help(s.substring(s.length()/2+1));
		return left*right+middle;
	}
	
	
	public static void main(String[] args) {
		System.out.print(numDecodings("01"));
	}
}
