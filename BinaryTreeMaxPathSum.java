package lab;

public class BinaryTreeMaxPathSum {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10, null, null);

		root.left = new TreeNode(15, null, null);
		root.right = new TreeNode(-5, null, null);

		root.left.left = new TreeNode(-20, null, null);
		root.left.right = new TreeNode(-40, null, null);

		root.right.right = new TreeNode(-10, null, null);


		System.out.println(calcMaxPathSum(root));

	}

	public static int calcMaxPathSum(TreeNode root) {
		return calcMaxPathSumHelper(root).maxSum;
	}

	private static NodePair calcMaxPathSumHelper(TreeNode root) {
		NodePair newPair = new NodePair();
		if (root == null) return newPair;

		NodePair left = calcMaxPathSumHelper(root.left);
		NodePair right = calcMaxPathSumHelper(root.right);

		int rootToNodeMaxSum = Math.max(left.nodeMaxSum, right.nodeMaxSum) + root.val;//Maximum sun including the current node
		int overAllMax = getMaxSum(left.maxSum, right.maxSum, left.nodeMaxSum + right.nodeMaxSum + root.val, root.val, rootToNodeMaxSum);//Over all max so far

		newPair.nodeMaxSum = Math.max(rootToNodeMaxSum, root.val);// This case handles the scenario where in the over all rootToNodeMaxSum is -ve, then only consider the present root node
		newPair.maxSum = overAllMax;



		return newPair;
	}

	private static int getMaxSum(int... arr) {
		int maxVal = arr[0];
		for (int temp : arr) {
			maxVal = Math.max(temp, maxVal);
		}
		return maxVal;
	}

	private static class NodePair {
		int maxSum = Integer.MIN_VALUE;
		int nodeMaxSum = 0;
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
