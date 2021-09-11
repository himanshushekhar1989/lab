package lab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeDiagonalView {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(10, null, null);
		root.left = new TreeNode(30, null, null);
		root.right = new TreeNode(20, null, null);

		root.left.left = new TreeNode(60, null, null);
		root.left.right = new TreeNode(50, null, null);

		root.left.left.right = new TreeNode(9, null, null);
		root.left.left.right.right = new TreeNode(7, null, null);

		root.left.left.left = new TreeNode(8, null, null);
		root.left.left.left.right = new TreeNode(55, null, null);
		root.left.left.right = new TreeNode(1, null, null);
		root.left.left.right.right = new TreeNode(0, null, null);

		root.right.left = new TreeNode(70, null, null);
		root.right.right = new TreeNode(90, null, null);

		root.right.right.right = new TreeNode(100, null, null);

		root.right.right.left = new TreeNode(6, null, null);
		root.right.right.left.left = new TreeNode(5, null, null);
		root.right.right.left.right = new TreeNode(2, null, null);


		clockWise(root);
		System.out.println("anti");
		antiClockWise(root);

		System.out.println("New Method");

		List<List<Integer>> list = new ArrayList<>();
		method2ClockWise(root, 0, list);
		list.forEach(System.out::println);
		System.out.println("anti");
		List<List<Integer>> list2 = new ArrayList<>();
		method2AntiClockWise(root, 0, list2);
		list2.forEach(System.out::println);

	}

	private static void method2AntiClockWise(TreeNode root, int level, List<List<Integer>> list) {
		if (root == null) {
			return;
		}
		if (list.size() == level) {
			list.add(level, new ArrayList<>());
		}
		list.get(level).add(root.val);
		method2AntiClockWise(root.right, level + 1, list);
		method2AntiClockWise(root.left, level + 0, list);


	}

	private static void method2ClockWise(TreeNode root, int level, List<List<Integer>> list) {

		if (root == null) {
			return;
		}
		if (list.size() == level) {
			list.add(level, new ArrayList<>());
		}
		list.get(level).add(root.val);
		method2ClockWise(root.left, level + 1, list);
		method2ClockWise(root.right, level + 0, list);
	}

	private static void antiClockWise(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		LinkedList<TreeNode> linkedList = new LinkedList<>();
		linkedList.addLast(root);

		while (linkedList.size() > 0) {
			int size = linkedList.size();
			List<Integer> res = new ArrayList<>();

			while (size-- > 0) {
				TreeNode removed = linkedList.removeFirst();

				while (removed != null) {
					res.add(removed.val);
					if (removed.right != null) {
						linkedList.addLast(removed.right);
					}
					removed = removed.left;
				}
			}
			result.add(res);
		}

		result.forEach(System.out::println);
	}

	private static void clockWise(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		LinkedList<TreeNode> linkedList = new LinkedList<>();
		linkedList.addLast(root);

		while (linkedList.size() > 0) {
			int size = linkedList.size();
			List<Integer> res = new ArrayList<>();

			while (size-- > 0) {
				TreeNode removed = linkedList.removeFirst();

				while (removed != null) {
					res.add(removed.val);
					if (removed.left != null) {
						linkedList.addLast(removed.left);
					}
					removed = removed.right;
				}
			}
			result.add(res);
		}

		result.forEach(System.out::println);
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
