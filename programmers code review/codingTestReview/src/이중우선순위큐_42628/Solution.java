package 이중우선순위큐_42628;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
//	int arr[]=s.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
//
//	System.out.println(arr[0] + " , " + arr[1]);
//}
	
	int size=0;

 public int[] solution(String[] operations) {
	 Queue<Integer> maxQueue=new PriorityQueue<Integer>((a,b)->b-a);
	 Queue<Integer> minQueue=new PriorityQueue<Integer>((a,b)->a-b);
	 
	 
	 for(String op :operations) {
		 op=op.replaceAll("\\s+","");
		// System.out.println(op);
		 if(op.startsWith("D1")) {
			 op=op.replace("D1", "");
			 
			 
			 if(maxQueue.size()>0) {
				 int remove=maxQueue.poll();
				 //삭제한것을 min에서도 삭제를한다
				 minQueue.remove(remove);
			//	 size--;
//				 if(size==0) {
//					 minQueue.clear();
//					 maxQueue.clear();
//				 }
			 }
		 }else if(op.startsWith("D-1")) {
			 op=op.replace("D-1", "");
			 
			 if(minQueue.size()>0) {
				int remove= minQueue.poll();
				maxQueue.remove(remove);
				// size--;
//				 if(size==0) {
//					 minQueue.clear();
//					 maxQueue.clear();
//				 }
			 }
		 }else {
			 op=op.replace("I", "");
			 int d= Integer.parseInt(op);
			 
			 maxQueue.add(d);
			 minQueue.add(d);
			 
		//	 size++;
		 }
				
	 }
	 
	 
	 int answer[]=new int[2];
//	 answer[0]=size==0 ? 0 : maxQueue.peek();
//	 answer[1]=size==0 ? 0 : minQueue.peek();
	 
	 
	 answer[0]=maxQueue.size()==0 ? 0 : maxQueue.peek();
	 answer[1]=minQueue.size()==0 ? 0 : minQueue.peek();
	 System.out.println(Arrays.toString(answer));
	 return answer;
	 
	 
 }

}
