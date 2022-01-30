package question2.data_structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinarySearchTree {
	
	private static Scanner in = new Scanner(System.in);
	private Node root = null;
	
	public Node getRoot() {
		return root;
	}

	static class Node {
		int key;
		Node left;
		Node right;
	}
	
	static Node newNode(int key) {
		Node n = new Node();
		n.key = key;
		n.left = null;
		n.right = null;
		return n;
	}
	
	public void insertNode() {
		System.out.println("Enter value to insert : ");
		int key = in.nextInt();
		in.nextLine();
		
		Node newNode = newNode(key);
		
		if(this.root == null) {
			this.root = newNode;
			return;
		}
		else {
			Node x = this.root;
			Node current_parent = null;
			while(x != null) {
				current_parent = x;
				if(newNode.key < x.key) {
					x = x.left;
				}
				else if(newNode.key > x.key) {
					x = x.right;
				}
				else {
					System.out.println("Value already exists!!!");
					return;
				}
			}
			
			if(newNode.key < current_parent.key) {
				current_parent.left = newNode;
			}
			else {
				current_parent.right = newNode;
			}
			
			return;
		}		
	}
	
	public void deleteNode() {
		if(this.root == null) {
			System.out.println("Binary Tree is empty!");
			return;
		}
		
		System.out.print("Enter value to delete : ");
		int key = in.nextInt();
		
		this.deleteRecursive(this.root, key);
	}
	
	public Node deleteRecursive(Node n, int key) {
		if(n == null)
		{
			return n;
		}
		
		if(key < n.key) {
			n.left = this.deleteRecursive(n.left, key);
		}
		else if(key > n.key) {
			n.right = this.deleteRecursive(n.right, key);
		}
		else {
			if(n.left == null) {
				return n.right;
			}
			else if(n.right == null) {
				return n.left;
			}
			else {
				n.key = this.findMinNode(n.right);
				n.right = this.deleteRecursive(n.right, n.key);
			}
		}
		return n;
		
	}
	
	public int findMinNode(Node n) {
		int key = n.key;
		while(n.left != null) {
			key = n.left.key;
			n = n.left;
		}
		return key;
	}

	public void searchNode() {
		System.out.println("Enter value to search for : ");
		int key = in.nextInt();
		in.nextLine();
		
		Node n = this.root;
		boolean found = false;
		while(n != null) {
			if(key < n.key) {
				n = n.left;
			}
			else if(key > n.key) {
				n = n.right;
			}
			else if(n.key == key) {
				found = true;
				break;
			}
			else {
				continue;
			}
		}
		
		if(found == false) {
			System.out.println("\nElement not found!");
		}
		else {
			System.out.println("\nElement present in BST...");
		}
	}
	
	public void inOrder(Node n) {
		if(n == null) {
			return;
		}
		else {
			this.inOrder(n.left);
			System.out.print(n.key + " ");
			this.inOrder(n.right);
		}
	}
	
	public void preOrder(Node n) {
		if(n == null) {
			return;
		}
		else {
			System.out.print(n.key + " ");
			this.preOrder(n.left);
			this.preOrder(n.right);
		}
	}
	
	public void postOrder(Node n) {
		if(n == null) {
			return;
		}
		else {
			this.postOrder(n.left);
			this.postOrder(n.right);
			System.out.print(n.key + " ");
		}
	}
	
	public void leveByLevel() {
		if(this.root == null) {
			System.out.println("Binary Tree is empty!");
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(this.root);
		
		while(!q.isEmpty()) {
			Node tempNode = q.remove();
			System.out.print(tempNode.key + " ");
			
			if(tempNode.left != null) {
				q.add(tempNode.left);
			}
			if(tempNode.right != null) {
				q.add(tempNode.right);
			}
		}
	}
	
	public int heightOfTree(Node n) {
		if(n == null) {
			return 0;
		}
		else {
			int right_height = this.heightOfTree(n.right);
			int left_height = this.heightOfTree(n.left);
			
			return (right_height > left_height ? (right_height + 1) : (left_height + 1));
		}
	}
	
	public void leftSkew() {
		if(this.root == null) {
			System.out.println("Binary Tree is empty!");
			return;
		}
		else {
			Node n = this.root;
			while(n != null) {
				System.out.print(n.key + " ");
				n = n.left;
			}
		}
	}
	
	private Stack<Integer> tracePath(Node n) {
		if(n.left == null && n.right == null) {
			Stack<Integer> s = new Stack<Integer>();
			s.push(n.key);
			return s;
		}
		else {
			Stack<Integer> leftPath = new Stack<Integer>();
			if(n.left != null) {
				leftPath = tracePath(n.left);
			}
			
			Stack<Integer> rightPath = new Stack<Integer>();
			if(n.right != null) {
				rightPath = tracePath(n.right);
			}
			
			if(leftPath.size() > rightPath.size()) {
				leftPath.push(n.key);
				return leftPath;
			}
			else {
				rightPath.push(n.key);
				return rightPath;
			}
		}		
	}
	
	public void getLongestPath() {
		Stack<Integer> longestPath = this.tracePath(this.root);
		
		System.out.println("\nLongest Path in tree :");
		int longestPathSize = longestPath.size();
		for(int i = 0; i < longestPathSize; ++i) {
			if(i == longestPathSize - 1) {
				System.out.print(longestPath.pop());
			}
			else {
				System.out.print(longestPath.pop() + "-->");
			}
		}
	}

}
