package 야근지수_12927;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		long n=s.solution(3, new int[] {1,1});
//		System.out.println(n);
//	}

	
	   public long solution(int n, int[] works) {
		   
		   Queue<Integer> priorityQueue=new PriorityQueue<Integer>((a,b)->b-a);
		   
		   int arrSum=Arrays.stream(works)
				   			.sum();
		   
		   if(arrSum < n) {
			   return 0;
		   }
		   
		   for(int i : works) {
			   priorityQueue.add(i);
		   }
		   
		 
		   for(int i=0; i<n; i++) {
			   int pop=priorityQueue.poll()-1;
			   priorityQueue.add(pop);
		   }
		   
		   long sum=0;
		   while(!priorityQueue.isEmpty()) {
			   sum+=(long)Math.pow(priorityQueue.poll(),2);
		   }
		   System.out.println(sum);
		   return sum;
	   }
}
