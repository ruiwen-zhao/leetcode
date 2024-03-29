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
	public int maxDepth(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
        	return 0;
        int levelNum = 1;
        int nextNum = 0;
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
        		res.add(new ArrayList<Integer>(nums));
        		nums.clear();
        		levelNum = nextNum;
        		nextNum = 0;
        	}
        }
        return res.size();
    }
}
