package com.him.tree;

public class TreeTest {
	public static void main(String[] args) {
		Node root = new Node(50);
		root.left = new Node(25);
		root.left.left = new Node(12);
		root.left.right = new Node(37);
		root.left.right.left = new Node(30);

		root.right = new Node(75);
		root.right.left = new Node(62);
		root.right.left.left = new Node(80);
		printSingleChildNode(root);

	}


	static void printSingleChildNode(Node node) {
		if (node == null) {
			return;
		}
		if ((node.left != null && node.right == null) || (node.left == null && node.right != null)) {
			System.out.println(node.data);
		}
		printSingleChildNode(node.left);
		printSingleChildNode(node.right);
	}

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
}


