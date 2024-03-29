package main;

import java.util.ArrayList;
import java.util.List;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null)
			return res;
		recursive(root, new ArrayList<Integer>(), res, 0, sum);
		return res;
    }
	
	static void recursive(TreeNode root, List<Integer> part, List<List<Integer>> res, int total, int sum) {
		part.add(root.val);
		total += root.val;
		
		if(root.left == null && root.right == null) {
			if(total == sum)
				res.add(new ArrayList<Integer>(part));
		}
		
		if(root.left != null) {
			recursive(root.left, part, res, total, sum);
		}
		if(root.right != null) {
			recursive(root.right, part, res, total, sum);
		}
		
		part.remove(part.size()-1);
		total -= root.val;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		List<List<Integer>> res = pathSum(root, 9);
		for(List<Integer> list : res)
			for(int i : list)
				System.out.print(i);
	}
}
