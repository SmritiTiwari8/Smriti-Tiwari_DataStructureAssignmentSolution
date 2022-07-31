package com.learning.bst;

import java.io.*;

class Node {
	int val;
	Node left, right;

	Node(int item) {
		val = item;
		left = right = null;
	}
}

public class Skewed_BST {

	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void flattenBTToSkewed(Node root) {

		if (root == null) {
			return;
		}

		flattenBTToSkewed(root.left);

		// Node rightNode = root.right;
		// Node leftNode = root.left;

		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

	}

	static void RightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		RightSkewed(root.right);
	}

	public static void main(String[] args) {

		Skewed_BST tree = new Skewed_BST();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(55);
		tree.node.right.right = new Node(60);
		tree.node.left.left = new Node(10);

		tree.flattenBTToSkewed(node);
		tree.RightSkewed(headNode);
	}
}
