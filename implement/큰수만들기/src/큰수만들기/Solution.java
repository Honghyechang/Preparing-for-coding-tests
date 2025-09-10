package 큰수만들기;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

	List<Long> list=new ArrayList<Long>();
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		String str=s.solution("1231234",3);
//		System.out.println(str);
//	}
	
	public String solution(String number, int k) {
	
		Stack<Character> stack=new Stack<Character>();
		
		for(char ch : number.toCharArray()) {
			
			while(k>0 && !stack.isEmpty() && stack.peek() < ch) {
				stack.pop();
				k--;
			}
			//k가 끝났을경우는 나머지 push
			stack.push(ch);
		}
		
		//다 돌았는데도 k가 0이상인경우는 그냥 그상태에서 pop
		while(k>0) {
			stack.pop();
			k--;
		}
		
		StringBuilder sb=new StringBuilder();
		
		while(!stack.isEmpty()) {
			char popCh=stack.pop();
			sb.insert(0, popCh);
			//System.out.println(sb.toString());
		}
		return sb.toString();
    }
	
	public void dfs(String number, int k, int step , String word) {
		if(step==k) {
			
			if(!list.contains(Long.parseLong(word))) {
				list.add(Long.parseLong(word));
				//System.out.println(word);
			}
			
			return;
		}
		
		//나를 뽑으면 그 다음부터 뽑아야한다. 현재앞에꺼를 제외시키고 그 뒤에 단어를 넘기면된다.
		//만약 앞에서도 뽑을 수 있었다면 본인을 제외 시키고 number을 넘겨줬을것이다.
		for(int i=0; i<number.length(); i++) {
			String newWord=word+number.charAt(i);
			String newNumber=number.substring(i+1);
			dfs(newNumber,k,step+1,newWord);
		}
	}

}
