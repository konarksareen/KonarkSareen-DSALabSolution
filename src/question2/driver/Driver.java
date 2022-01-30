package question2.driver;

import java.util.Scanner;

import question2.data_structure.BinarySearchTree;

public class Driver {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		BinarySearchTree Obj = new BinarySearchTree();
		
		char status = 'a';
		
		do {
			System.out.println("\nEnter your choice : ");
			System.out.println("0. I am done...\n1. Insert\n2. Deletion\n3. Height of Tree\n4. Print Binary Tree (Level by Level)\n5. Print Binary Tree (Inorder)\n6. Print Binary Tree (Preorder)\n7. Print Binary Tree (Postorder)\n8. Find the longest path.");
			int choice = in.nextInt();
			
			switch(choice) {
				case 0 :
					status = 's';
					break;
				case 1 :
					Obj.insertNode();
					break;
				case 2 :
					Obj.deleteNode();
					break;
				case 3 :
					System.out.println("\nHeight of Tree : " + (Obj.heightOfTree(Obj.getRoot()) - 1));
					break;
				case 4 :
					System.out.println("Binary Tree (level by level) : ");
					Obj.leveByLevel();
					break;
				case 5 :
					System.out.println("Binary Tree (inorder) : ");
					Obj.inOrder(Obj.getRoot());
					break;
				case 6 :
					System.out.println("Binary Tree (preorder) : ");
					Obj.preOrder(Obj.getRoot());
					break;
				case 7 :
					System.out.println("Binary Tree (postorder) : ");
					Obj.postOrder(Obj.getRoot());
					break;
				case 8 :
					Obj.getLongestPath();
					break;
				default :
					System.out.println("Invalid Input!");
			}
		} while(status != 's');
		
		in.close();
	}
}
