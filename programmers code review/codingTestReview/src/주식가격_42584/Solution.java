package 주식가격_42584;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution(new int[] {1,2,3,2,3});
//}

	public int[] solution(int[] prices) {
		int answer[]=new int[prices.length];
		Stack<Location> stack=new Stack<Solution.Location>();
		
		for(int i=0; i< prices.length; i++) {
			Location location=new Location(prices[i],i);
			
			//내가 push 가 가능할때까지 확인하고,
			//불가능하다면 pop 해서 현재 i와 pop한 것과 비교해서 answer에 업데이트한다.
			while(!stack.isEmpty() && stack.peek().value > location.value) {
				Location decreaseLocation=stack.pop();
				int index=decreaseLocation.location;
				int answerValue=location.location-index;
				answer[index]=answerValue;
			}
			
			stack.push(location);
		}
		int last=prices.length-1;
		while(!stack.isEmpty()) {
			Location decreaseLocation=stack.pop();
			int index=decreaseLocation.location;
			int answerValue=last-index;
			answer[index]=answerValue;
		}
		
		//System.out.println(Arrays.toString(answer));
		return answer;
		
	}

	class Location{
		//현재 내 위치와 값을 가지고 있다
		int value;
		int location;
		public Location(int value, int location) {
			this.location=location;
			this.value=value;
		}
		
	}
}
