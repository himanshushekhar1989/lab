package com.him.tree;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TestTree {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1, null, null);

		root.left = new BinaryTreeNode<>(2, null, null);
		root.left.left = new BinaryTreeNode<>(4, null, null);
		root.left.right = new BinaryTreeNode<>(5, null, null);

		root.right = new BinaryTreeNode<>(9, null, null);
		root.right.left = new BinaryTreeNode<>(6, null, null);
		root.right.right = new BinaryTreeNode<>(7, null, null);

		TreeTraversal treeTraversal = new TreeTraversal();
		//treeTraversal.preOrder(root);
		System.out.println();
		//treeTraversal.preOrderIterative(root);
		//treeTraversal.levelOrderTraversal(root);
		//System.out.println("Max element in tree " + treeTraversal.maxInBinaryTree(root));
		//System.out.println("is 1 available in tree: " + treeTraversal.findElementInTree(root, 1));
		//treeTraversal.reverseTraversal(root);

		System.out.println("Height of binary Tree " + height(root));
		System.out.println("Max of binary Tree " + max(root));
		System.out.println("Sum of binary Tree " + sum(root));
		System.out.println("Size of binary Tree " + size(root));
		Comparator<BinaryTreeNode> cmp = new Comparator<>() {

			@Override
			public int compare(BinaryTreeNode o1, BinaryTreeNode o2) {
				return (Integer) o1.data -(Integer)o2.data;
			}
		};
		Comparator<BinaryTreeNode> cmp1 =( o1,  o2)->(Integer) o1.data -(Integer)o2.data;

				PriorityQueue<BinaryTreeNode> queue = new PriorityQueue<>(cmp1);
	}

	static int height(BinaryTreeNode<Integer> node) {
		if (node == null) {
			return -1;
		}
		int h1 = height(node.left);
		int h2 = height(node.right);
		return Math.max(h1, h2) + 1;
	}

	static int max(BinaryTreeNode<Integer> node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int leftMax = max(node.left);
		int rightMax = max(node.right);

		return Math.max(node.data, Math.max(leftMax, rightMax));
	}

	static int sum(BinaryTreeNode<Integer> node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int leftSum = sum(node.left);
		int rightSum = sum(node.right);

		return leftSum + rightSum + node.data;
	}

	static int size(BinaryTreeNode<Integer> node) {
		if (node == null) {
			return 0;
		}
		int leftSize = size(node.left);
		int rightSize = size(node.right);
		return leftSize + rightSize + 1;

	}
}
