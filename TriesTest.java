package com.him.tries;

public class TriesTest {

	public static void main(String[] args) {
		Tries tries = new Tries();
		tries.insert("cat");
		tries.insert("cats");
		tries.insert("cope");

		System.out.println("is cats a word " + tries.search("cats"));
		System.out.println("is cat a word " + tries.startsWith("cat"));
		System.out.println("is cat a word " + tries.search("cat"));
	}
}
