// Binary tree have three ways to traversal
// preorder: current node, left subtree, right substree
// inorder: left substree, current node, right substree
// postorder: left substree, right substree, current node

class TreeNode {
	int val;
	TreeNode right;
	TreeNode left;
	public TreeNode(int val, left, right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}


public class BTTraversal {
	//visit the node 
	public static void visit(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
		}
	}
	// preorder
	public void preorder(TreeNode root) {
		if (root == null) return;
		visit(root);
		preorder(root.left);
		preorder(root.right);
	}

	//inorder traversal
	public void inorder(TreeNode root) {
		if (root == null) return;
		inorder(root.left);
		visit(root);
		inorder(root.right);
	}

	// postOrder traversal
	public void postOrder(TreeNode root) {
		if (root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		visit(root);
	}

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1,two, three);
		TreeNode two = new TreeNode(2, four, five);
		TreeNode three = new TreeNode(3, six, null);
		TreeNode four = new TreeNode(4, null, null);
		TreeNode five = new TreeNode(5, null, null);
		TreeNode six = new TreeNode(6, null, null);
		preorder(one);
		System.out.println();
		inorder(one);
		System.out.println();
		postOrder(one);

	}
}