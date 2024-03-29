package main;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public int sumNumbers(TreeNode root) {
		int part = 0;
		int []sum = new int[1];
		recursive(root, sum, part);
		return sum[0];
	}
	
	void recursive(TreeNode root, int[] sum, int part) {
		if(root == null)
			return;
		part = part * 10 + root.val;
		if(root.left == null && root.right == null) {
			sum[0] += part;
			return;
		}
		recursive(root.left, sum, part);
		recursive(root.right, sum, part);
	}
	
	
}
