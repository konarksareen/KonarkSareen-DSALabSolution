package question1.utilities;

import java.util.Stack;

public class BalanceBrackets {

	private String str;
	private Stack<Character> stack = new Stack<Character>();
	
	public BalanceBrackets(String str) {
		this.str = str;
	}
	
	public void findBrackets() {
		char c, dir;
		Boolean correctBracket = false;
		for(int i = 0; i < this.str.length(); ++i) {
			dir = this.bracketDirection(this.str.charAt(i));
			if(dir == 'o') {
				this.stack.push(this.str.charAt(i));
			}
			else if(dir == 'c') {
				if(this.stack.isEmpty()) {
					correctBracket = false;
					break;
				}
				else {
					c = this.stack.pop();
					correctBracket = this.checkCorrectBracket(this.str.charAt(i), c);
					if(correctBracket == false) {
						break;
					}
					else {
						continue;
					}
				}
			}
			else {
				continue;
			}
		}
		
		if(!this.stack.isEmpty()) {
			System.out.println("\nThe entered String do not contain Balanced Brackets.");
			return;
		}
		if(correctBracket == true) {
			System.out.println("\nThe entered String has Balanced Brackets.");
		}
		else {
			System.out.println("\nThe entered String do not contain Balanced Brackets.");
		}
	}
	
	private Boolean checkCorrectBracket(char string_c, char stack_c) {
		if((string_c == '}' && stack_c == '{') || (string_c == ']' && stack_c == '[') || (string_c == ')' && stack_c == '(')) {
			return true;
		}
		else {
			return false;
		}
	}
	private char bracketDirection(char c) {
		if(c == '(' || c == '[' || c == '{') {
			return 'o'; 
		}
		else if(c == ')' || c == ']' || c == '}') {
			return 'c';
		}
		else {
			return 'n';
		}
	}
}
