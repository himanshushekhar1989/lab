package com.him.tries;

public class Tries {
	Node root;

	public Tries() {
		root = new Node('\0');
	}

	public void insert(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			if (curr.children[word.charAt(i) - 'a'] == null)
				curr.children[word.charAt(i) - 'a'] = new Node(word.charAt(i));
			curr = curr.children[word.charAt(i) - 'a'];
		}
		curr.isWord = true;

	}

	public boolean search(String word) {
		Node node = getNode(word);
		return node != null && node.isWord;
	}

	public boolean startsWith(String prefix) {
		Node node = getNode(prefix);
		return node != null;
	}

	private Node getNode(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			if (curr.children[word.charAt(i) - 'a'] == null) return null;
			curr = curr.children[word.charAt(i) - 'a'];
		}
		return curr;
	}


	private class Node {
		public char curr;
		public boolean isWord;
		public Node[] children;

		public Node(char curr) {
			this.curr = curr;
			isWord = false;
			children = new Node[26];
		}
	}
}

