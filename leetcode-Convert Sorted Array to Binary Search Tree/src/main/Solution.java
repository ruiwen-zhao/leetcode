package main;


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
        	return null;
        return recursive(nums, 0, nums.length-1);
    }
	
	static TreeNode recursive(int []nums, int begin, int end) {
		if(begin > end)
			return null;
		
		int mid = (begin + end)/2;
		TreeNode head = new TreeNode(nums[mid]);
		head.left = recursive(nums, begin, mid-1);
		head.right = recursive(nums, mid+1, end);
		return head;
	}
	
	public static void main(String[] args) {
		int nums[] = {1,2,3,4,5};
		sortedArrayToBST(nums);
	}
}
