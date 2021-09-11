package com.him.tree;

public class TreeMirror {

	/*
	 * 			1
	 *
	 * 		2			3
	 *
	 * 	4		5	6		7
	 *
	 * */

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);

		TreeMirror tree =new TreeMirror();
		tree.makeMirror(root);
		tree.transverse(root);

	}


	void makeMirror(Node root) {
		if(root!=null){
			if(root.left!=null || root.right != null ){
				Node temp = root.left;
				root.left = root.right;
				root.right = temp;
				if(root.left!=null)
				makeMirror(root.left);
				if(root.right!=null)
				makeMirror(root.right);
			}
		}

	}

	void transverse(Node root){
		if(root == null){
			return;
		}
		System.out.print(root.data+ " ");
		transverse(root.left);
		transverse(root.right);

	}

}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}
