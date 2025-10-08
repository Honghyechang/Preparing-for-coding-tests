package 올바른괄호_12909;

import java.util.Stack;

public class Solution {
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	
	boolean solution(String s) {
		// '('일 때는 push
		// ')'일 때는 pop
		// 스택이 비어있지 않거나, pop을 하는데 스택이 비어있는 경우 문제 발생
		
		Stack<Character> stack=new Stack<Character>();
		for(int i=0; i<s.length(); i++) {
			char ch=s.charAt(i);
			if(ch=='(') {
				stack.push(ch);
			}else {
				if(stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		
		if(!stack.isEmpty())return false;
		
		return true;
		
	}

}
