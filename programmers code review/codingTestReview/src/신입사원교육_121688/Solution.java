package 신입사원교육_121688;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//	Solution s=new Solution();
//	s.solution(new int[] {10, 3, 7, 2}, 2);
//}

public int solution(int[] ability, int number)
{
	
	Queue<Integer> queue= new PriorityQueue<Integer>();
	for(int n : ability) {
		queue.add(n);
	}
	
	for(int i=0; i<number; i++) {
	 int a=queue.poll();
	 int b=queue.poll();
	 int c=a+b;
	 queue.add(c);
	 queue.add(c);
	}
	
	int sum=0;
	while(!queue.isEmpty()) {
		sum+=queue.poll();
	}
	System.out.println(sum);
	return sum;
	
}
}
