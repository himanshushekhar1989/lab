package lab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BinaryTreeVerticalOrderTraversal {

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


		method1(root);
	}




	private static void method1(TreeNode root) {
		LinkedList<NodePair> list = new LinkedList<>();
		NodePair nPair = new NodePair(root, 0);
		Map<Integer, List<Integer>> map = new HashMap<>();
		list.addLast(nPair);
		int lSpan = 0;
		int rSpan = 0;

		while (list.size() > 0) {
			NodePair removed = list.removeFirst();
			int level = removed.level;
			lSpan = Math.min(level, lSpan);
			rSpan = Math.max(level, rSpan);
			if (!map.containsKey(level)) {
				map.put(level, new ArrayList<>());
			}
			map.get(level).add(removed.node.val);
			if (removed.node.left != null) {
				list.addLast(new NodePair(removed.node.left, level - 1));
			}
			if (removed.node.right != null) {
				list.addLast(new NodePair(removed.node.right, level + 1));
			}
		}

		for (int i = lSpan; i <= rSpan; i++) {
			map.get(i).forEach(l -> System.out.print(l + " "));
		}
	}

	static class NodePair {
		TreeNode node;
		int level;

		public NodePair(TreeNode node, int leve) {
			this.node = node;
			this.level = leve;
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
