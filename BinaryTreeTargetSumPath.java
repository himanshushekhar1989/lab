package lab;

public class BinaryTreeTargetSumPath {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(7, null, null);

		root.left = new TreeNode(3, null, null);
		root.right = new TreeNode(12, null, null);

		root.left.left = new TreeNode(1, null, null);
		root.left.left.left = new TreeNode(3, null, null);
		root.left.left.right = new TreeNode(0, null, null);

		root.right.left = new TreeNode(9, null, null);
		root.right.left.left = new TreeNode(-17, null, null);
		root.right.left.right = new TreeNode(-27, null, null);
		root.right.left.right.left = new TreeNode(10, null, null);


		root.right.right = new TreeNode(13, null, null);
		root.right.right.left = new TreeNode(15, null, null);
		root.right.right.left.right = new TreeNode(14, null, null);


		printTargetSumPath(root, "", 0, 11);

	}

	private static void printTargetSumPath(TreeNode root, String psf, int sum, int target) {
		if (root == null) return;
		if (sum + root.val == target && root.left == null && root.right == null) {
			System.out.println(psf + " " + root.val);
			return;
		}

		printTargetSumPath(root.left, psf + " " + root.val, sum + root.val, target);
		printTargetSumPath(root.right, psf + " " + root.val, sum + root.val, target);

	}

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
