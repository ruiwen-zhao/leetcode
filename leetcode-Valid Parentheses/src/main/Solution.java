package main;

import java.util.Stack;

public class Solution {
	public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
        	
        	switch(s.charAt(i)) {
        		case ')':
        			if(!stack.isEmpty() && stack.peek().equals("("))
        				stack.pop();
        			else 
						stack.push(")");
        			break;
        			
        		case ']':
        			if(!stack.isEmpty() && stack.peek().equals("["))
        				stack.pop();
        			else 
						stack.push("]");
        			break;
        			
        		case '}':
        			if(!stack.isEmpty() && stack.peek().equals("{"))
        				stack.pop();
        			else 
						stack.push("}");
        			break;
				
        		default:
        			stack.push(new String("" + s.charAt(i)));
        	}
        }
        	
        return stack.isEmpty();	
    }
	
	public static void main(String[] args) {
		System.out.print(isValid("{[()]}"));
	}
	
	
}
