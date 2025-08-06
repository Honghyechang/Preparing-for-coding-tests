package 괄호회전하기;

import java.util.Stack;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		Solution s=new Solution();
//		s.solution("[](){}");
//
//	}
	
	   public int solution(String s) {
		   
		   String changeStr=new String(s);
		   int count=0;
		   for(int i=0;i<s.length(); i++) {
			   //System.out.println(changeStr);
			   if(check(changeStr)) {
				  // System.out.println("count ++");
				   count++;
			   }
			   changeStr=changeStr.substring(1)+changeStr.charAt(0);
		   }
		   
		   return count;
	    }
	   
	   
	   
	   public boolean check(String str) {
		   Stack<Character> stack =new Stack<Character>();
		   
		   for(int i=0; i<str.length(); i++) {
			   char ch=str.charAt(i);
			   
			   switch(ch) {
			   case '(' :
			   case '[' :
			   case '{' :
				   stack.push(ch);
				   break;
			   case ')':
			   	if(stack.isEmpty() || stack.pop()!='(') return false;
			   	break;
			   	
			   case ']':
				   	if(stack.isEmpty() || stack.pop()!='[') return false;
				   	break;
				   	
			   case '}':
				   	if(stack.isEmpty() || stack.pop()!='{') return false;
				   	break;
			   }
		   }
		    
		   if(!stack.isEmpty()) return false;
		   return true;
		   
		   
	   }

}
