package 큰수만들기_42883;

import java.util.Stack;

public class Solution {
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//	Solution s=new Solution();
//	String str=s.solution("10",1);
//	System.out.println(str);
//}

public String solution(String number, int k) {
	char chars[]=number.toCharArray();
	Stack<Character> stack=new Stack<Character>();
	int popCount=0;
	
	boolean isBreak=false;
	for(char ch : chars) {

			
			while(!stack.isEmpty()  && stack.peek() - '0' < ch -'0' && !isBreak) {
				
					stack.pop();
					popCount++;
					
					if(popCount==k) {
						isBreak=true;
						break;
					}
				
			}
			stack.push(ch);
			
		
	}
	
	//popCount가 안채워졌을겨우가 있을것이다.
	while(popCount!=k) {
		stack.pop();
		popCount++;
	}
	
	StringBuilder sb=new StringBuilder();
	while(!stack.isEmpty()) {
		sb.append(stack.pop());
	}
	
	String answer=sb.reverse().toString();
	//System.out.println(answer);
	return answer;
}

}
