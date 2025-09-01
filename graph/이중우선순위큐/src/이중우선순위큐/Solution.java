package 이중우선순위큐;

import java.util.PriorityQueue;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		int arr[]=s.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
//
//		System.out.println(arr[0] + " , " + arr[1]);
//	}
//	
	 public int[] solution(String[] operations) {
		 
		 PriorityQueue<Integer> pqMax=new PriorityQueue<Integer>((a,b)->b-a);

		 PriorityQueue<Integer> pqMin=new PriorityQueue<Integer>((a,b)->a-b);
		 
		 int size=0;
		 
		 for(int i=0; i<operations.length; i++) {
			 String op=operations[i];
			 
			 if(op.startsWith("I")) {
				 String opp=op.replaceAll("I\\s+", "");
				 pqMax.add(Integer.parseInt(opp));
				 pqMin.add(Integer.parseInt(opp));
				 size++;
			 }
			 else if(op.replaceAll("\\s+", "").equals("D1")) {
				 
				 if(pqMax.isEmpty()) continue;
				 int m=pqMax.poll();
				 pqMin.remove(m);
				 size--;
				 if(size==0) {
					 pqMin.clear();
					 pqMax.clear();
				 }
				 
				 
			 }
			 else if(op.replaceAll("\\s+", "").equals("D-1")) {
				 if(pqMin.isEmpty()) continue;
				 int m=pqMin.poll();
				 pqMax.remove(m);
				 size--;
				 if(size==0) {
					 pqMax.clear();
					 pqMin.clear();
				 }
				 
				 
			 }
			 
			 
		 }
		 
		 return size==0? new int[] {0,0} : new int[] {pqMax.peek(),pqMin.peek()};
	    }

}
