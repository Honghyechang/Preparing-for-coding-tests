package 괄호회전하기_76502;

import java.util.Stack;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	
//	
//	Solution s=new Solution();
//	s.solution("}]()[{");
//
//}

   public int solution(String s) {
	   int answer=0;
	   if(s.length()%2==1) {
		   return 0;
	   }
	   Stack<Character> stack =new Stack<>();
	   for(int i=0; i<s.length(); i++) {
		   String start=s.substring(0,i);
		   String end=s.substring(i);
		   
		   String newWord=end+start;
		   stack.clear();
		   boolean isRight=true;
		   
		   for(char ch : newWord.toCharArray()) {
			   if(ch=='(' || ch=='[' || ch=='{') {
				   stack.push(ch);
			   }else if(ch==')') {
				   if(stack.isEmpty() || stack.peek()!='(') {
					   isRight=false;
					   break;
				   }  
				   stack.pop();
			   }else if(ch==']') {
				   if(stack.isEmpty() || stack.peek()!='[') {
					   isRight=false;
					   break;
				   }
				   

				   stack.pop();
			   }else if(ch=='}') {
				   if(stack.isEmpty() || stack.peek()!='{') {
					   isRight=false;
					   break;
				   }

				   stack.pop();
				   
			   }
			   
			   
		   }
		   
		   if(isRight) {
			   answer++;
		   }
		   
		  
		   
		   
	   }
	   System.out.println(answer);
	   return answer;
	   
	   
   }
}
