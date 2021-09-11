package com.him.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

	public void preOrder(BinaryTreeNode<Integer> root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}

	}

	public void preOrderIterative(BinaryTreeNode<Integer> root) {
		Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
		stack.push(root);
		while (!stack.empty()) {
			BinaryTreeNode<Integer> temp = stack.pop();
			System.out.print(temp.data + " ");
			if (temp.right != null) {
				stack.push(temp.right);
			}
			if (temp.left != null) {
				stack.push(temp.left);
			}
		}

	}

	public void inOrder(BinaryTreeNode<Integer> root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}

	}

	public void inOrderIterative(BinaryTreeNode<Integer> root) {
		Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
		stack.push(root);
		BinaryTreeNode<Integer> currentNode = root;
		var done = false;
		while (!done) {
			if (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.left;
			} else {
				if (stack.empty()) {
					done = true;
				}
				BinaryTreeNode<Integer> temp = stack.pop();
				System.out.println(temp.data);
				currentNode = temp.right;
			}
		}
	}

	public void postOrder(BinaryTreeNode<Integer> root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	public void levelOrderTraversal(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> temp = queue.poll();
			System.out.print(temp.data + " ");
			if (temp.left != null) {
				queue.offer(temp.left);
			}
			if (temp.right != null) {
				queue.offer(temp.right);
			}
		}
	}

	public int maxInBinaryTree(BinaryTreeNode<Integer> root) {
		Integer max = 0;
		if (root != null) {
			int leftInt = maxInBinaryTree(root.left);
			int rightInt = maxInBinaryTree(root.right);
			if (leftInt > rightInt) {
				max = leftInt;
			} else {
				max = rightInt;
			}
			if (root.data > max) {
				max = root.data;
			}
		}
		return max;
	}

	public boolean findElementInTree(BinaryTreeNode<Integer> root, int data) {
		if (root == null) {
			return false;
		}
		if (root.data == data) {
			return true;
		}
		return findElementInTree(root.left, data) || findElementInTree(root.right, data);

	}

	public void reverseTraversal(BinaryTreeNode<Integer> root) {
		Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();

		queue.offer(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> temp = queue.poll();
			if (temp.left != null) {
				queue.offer(temp.left);
			}
			if (temp.right != null) {
				queue.offer(temp.right);
			}
			stack.push(temp);
		}

		while (!stack.empty()) {
			System.out.print(stack.pop().data + " ");
		}
	}

}
