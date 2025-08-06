package 올바른괄호;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 boolean solution(String s) {
	      
		    Stack<Character> stack=new Stack<>();
		    
		    for(int i=0; i<s.length(); i++) {
		    	char ch=s.charAt(i);
		    	
		    	if(ch=='(') {
		    		stack.push(ch);
		    	}
		    	
		    	else {
		    		if(stack.isEmpty()) {
		    			return false;
		    		}
		    		stack.pop();
		    	}
		    
		    }
		    
		    if(!stack.isEmpty()) return false;
		    
		 
	        return true;
	    }
}
