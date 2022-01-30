package question1.driver;

import java.util.Scanner;

import question1.utilities.BalanceBrackets;

public class Driver {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the string containing brackets:");
		String str = in.nextLine();
		
		BalanceBrackets BB = new BalanceBrackets(str);
		
		BB.findBrackets();
		
		in.close();
	}

}
