package lab;

import java.util.LinkedList;

public class BinaryTreeLeftView {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(3, null, null);

		root.left = new TreeNode(1, null, null);
		root.right = new TreeNode(6, null, null);

		root.left.left = new TreeNode(0, null, null);
		root.left.right = new TreeNode(2, null, null);

		root.right.left = new TreeNode(5, null, null);
		root.right.right = new TreeNode(10, null, null);

		root.right.left.left = new TreeNode(4, null, null);
		root.right.left.right = new TreeNode(15, null, null);

		root.right.right.left = new TreeNode(9, null, null);
		root.right.right.right = new TreeNode(11, null, null);

		root.right.right.left.left = new TreeNode(12, null, null);

		root.right.right.left.left.left = new TreeNode(13, null, null);
		root.right.right.left.left.right = new TreeNode(14, null, null);

		LinkedList<TreeNode> linkedList = new LinkedList<>();
		linkedList.addLast(root);

		while (linkedList.size() > 0) {
			int size = linkedList.size();
			TreeNode removed = linkedList.getFirst();
			System.out.print(removed.val + " ");

			while (size-- > 0) {
				removed = linkedList.removeFirst();

				if (removed.left != null) {
					linkedList.addLast(removed.left);
				}
				if (removed.right != null) {
					linkedList.addLast(removed.right);
				}
			}
		}


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
