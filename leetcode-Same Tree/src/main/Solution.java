package main;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        pStack.push(p);
        qStack.push(q);
        
        while(!pStack.isEmpty() && !qStack.isEmpty()) {
        	p = pStack.pop();
        	q = qStack.pop();
        	
        	if(p != null && q != null) {
        		if(p.val != q.val)
        			return false;
        		pStack.push(p.left);
            	pStack.push(p.right);
            	qStack.push(q.left);
            	qStack.push(q.right);
        	}
        	
        	if(p != null && q == null || p == null && q != null)
        		return false;
        }
        
        if(!pStack.isEmpty() || !qStack.isEmpty())
        	return false;
        
        return true;
    }
	
	public static void main(String[] args) {
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);
		
		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(2);
		q.right = new TreeNode(3);
		q.left.left = new TreeNode(3);
		
		System.out.print(isSameTree(null, null));
	}
}
