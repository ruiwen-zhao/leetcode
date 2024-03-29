package main;

import java.util.Stack;

import javax.xml.stream.events.StartDocument;

public class Solution {
//	public static int longestValidParentheses(String s) {
//        int left = 0, right = 0;
//        int sub[] = new int[s.length()];
//        for(int i = 0 ; i < s.length(); i++) {
//        	if(s.charAt(i) == '(')
//        		left++;
//        	else
//        		right++;
//        	sub[i] = left-right;
//        }
//        
//        //boolean fail = false;
//        int maxLength = 0;
//        
//        for(int j = 0; j < s.length() && s.charAt(0) == '('; j++ ) {
//    		
//    		if(sub[j] < 0) {
//    			break;
//    		}
//    		
//    		if(s.charAt(j) == ')' && sub[j] == 0)
//    			maxLength = j+1 > maxLength ? j+1 : maxLength;
//    			
//    	}
//        
//        for(int i = 1; i < s.length(); i++) {
//        	if(s.charAt(i) != '(')
//        		continue;
//        	for(int j = i; j < s.length(); j++ ) {
//        		
//        		if(sub[j]-sub[i-1] < 0) {
//        			break;
//        		}
//        		
//        		if(s.charAt(j) == ')' && sub[j]-sub[i-1] == 0)
//        			maxLength = j-i+1 > maxLength ? j-i+1 : maxLength;
//        			
//        	}
//        }
//        
//        return maxLength;
//    }
	
	public static int longestValidParentheses(String s) {
		if(s == null || s.length() == 0)
			return 0;
		
		int maxLength = 0;
		int begin = -1;
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0 ; i < s.length(); i++ ) {
			if(s.charAt(i) == '(')
				stack.push(i);
			else {
				if(!stack.isEmpty()) {
					stack.pop();
					if(stack.empty()) {
						maxLength = i-begin > maxLength ? i-begin : maxLength;
					}
					else {
						maxLength = i-stack.peek() > maxLength ? i-(int)stack.peek() :maxLength;
					}
				}
				else {
					begin = i;
				}
			}
			
			
			
		}
		
		return maxLength;
		
		
		
	}
	
	public static void main(String[] args) {
		String string = "((((()";
		System.out.println(longestValidParentheses(string));
	}
}
