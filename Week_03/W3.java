package demo;

import java.util.HashMap;
import java.util.Map;

public class W3 {
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	      TreeNode right;
	     TreeNode(int x) { val = x; }
	  }
	 
	
	//此题有2点需要注意。1是wut is lowestCommonAncestor。2是后序遍历的顺序性，让return的第一次尝试（除root外），从离root最远的地方开始。
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	 if(null==root||root==p||root==q) {
		 return root;
	 }
	 TreeNode l= lowestCommonAncestor(root.left, p,  q);
	 TreeNode r= lowestCommonAncestor(root.right, p,  q);
	 
	 if(null==l) {
		 return r;
	 }
	 if(null==r) {
		 return l;
	 }
		 return root;
		 
	 }
	 
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
		    HashMap<Integer, Integer> map = new HashMap<>();
		    for (int i = 0; i < inorder.length; i++) {
		        map.put(inorder[i], i);
		    }
		    return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
		}

		private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end,
		                                 HashMap<Integer, Integer> map) {
		    if (p_start == p_end) {
		        return null;
		    }
		    int root_val = preorder[p_start];
		    TreeNode root = new TreeNode(root_val);
		    int i_root_index = map.get(root_val);
		    int leftNum = i_root_index - i_start;
		    root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index, map);
		    root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end, map);
		    return root;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
