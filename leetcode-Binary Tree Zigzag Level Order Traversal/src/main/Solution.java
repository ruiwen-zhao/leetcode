package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
        	return res;
        int levelNum = 1;
        int nextNum = 0;
        int dir = 0;
        List<TreeNode> level = new LinkedList<>();
        List<Integer> nums = new ArrayList<>();
        level.add(root);
        
        TreeNode p = null;
        while(!level.isEmpty()) {
        	p = level.get(0);
        	level.remove(0);
        	nums.add(p.val);
        	levelNum--;
        	
        	if(p.left != null) {
        		nextNum++;
        		level.add(p.left);
        	}
        	if(p.right != null) {
        		nextNum++;
        		level.add(p.right);
        	}
        	
        	
        	
        	if(levelNum == 0) {
        		if(dir % 2 == 1) {
        			List<Integer> temp = new ArrayList<>();
        			for(int i = nums.size()-1; i >= 0; i--)
        				temp.add(nums.get(i));
        			res.add(new ArrayList<Integer>(temp));
        		}
        		else
        			res.add(new ArrayList<Integer>(nums));
        		nums.clear();
        		levelNum = nextNum;
        		nextNum = 0;
        		dir++;
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(5);
		head.right.left = new TreeNode(6);
		List<List<Integer>> res = zigzagLevelOrder(head);
		
		for(List<Integer> list : res) {
			for(Integer i : list)
				System.out.print(i);
			System.out.print('\n');
		}
	}
}
