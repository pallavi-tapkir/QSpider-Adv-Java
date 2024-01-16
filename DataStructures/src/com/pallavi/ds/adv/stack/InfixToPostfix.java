package com.pallavi.ds.adv.stack;

import java.util.Stack;

public class InfixToPostfix {

	public static void main(String[] args) {
		System.out.print(solve("q+(c*t)*o+(g*g)+q*(i-a)*p-(i*l)"));
	}
	
//	The expected return value:
//	qct*o*+gg*+qia-*p*+il*-
	
//	Your function returned the following:
//	qct*o*+gg*+qia-*p*+il*-
	
	public static String solve(String A) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<A.length(); i++) {
			Character ch = A.charAt(i);
			if(ch >= 'a' && ch <= 'z') {
				sb.append(ch);
			}else if(ch == '(') {
				stack.push(ch);
			}else if(ch == ')') {
				while(stack.peek() != '(')
				{
					sb.append(stack.pop());
				}
				stack.pop();
			}else if(ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '^') {
				while(!stack.isEmpty() && stack.peek()!= '(' && precedence(stack.peek()) >= precedence(ch) ) {
					sb.append(stack.pop());
				}
				stack.push(ch);
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}
	
	public static int precedence(Character ch) {
		if(ch == '^') {
			return 3;
		}else if(ch == '*' || ch == '/') {
			return 2;
		}else {
			return 1;
		}
		
	}
}
