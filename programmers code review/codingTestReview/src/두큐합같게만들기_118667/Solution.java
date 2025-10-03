package 두큐합같게만들기_118667;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		int n=s.solution(new int[] {1,2,1,2}, new int[] {1,10,1,2});
//		System.out.println(n);
//	}

	 public int solution(int[] queue1, int[] queue2) {
		 
		 //System.out.println(Arrays.toString(queue1));
		 //System.out.println(Arrays.toString(queue2));
		 	Queue<Integer> queueOne=new LinkedList<Integer>();
		 	Queue<Integer> queueTwo=new LinkedList<Integer>();

		 	long oneSum=0;
		 	long twoSum=0;
		 	for(int i=0; i<queue1.length; i++) {
		 		queueOne.add(queue1[i]);
		 		oneSum+=queue1[i];
		 	}
		 	
		 	for(int i=0; i<queue2.length; i++) {
		 		queueTwo.add(queue2[i]);
		 		twoSum+=queue2[i];
		 	}
		 	
			long sum=oneSum+twoSum;
			
			//123 456
		 	
			if(oneSum==twoSum) {
				return 0;
			}
			
		 	double target=(double)sum/2;
		 	if(target%1!=0) {
		 		return -1;
		 	}
		 	long longTarget=(long)target;
			Queue<Integer> copyTwo=new LinkedList<Integer>(queueTwo);
		 	int min=0;
		 	
		 	int moveCount=0;
		    int maxSize=queueOne.size()*3;
		 	
		 	while(moveCount<maxSize&& !queueOne.isEmpty() && !queueTwo.isEmpty()) {
		 	
		 		//현재 sum이 intTarget보다 크면, 빼고 작은면 insert한다.
		 		//이때 onequeue가 toqueue랑 동일해질경우, 이것은 break 동시에 못찾음 결과
		 		if(oneSum==longTarget) {
		 			return moveCount;
		 		}else if(oneSum>longTarget) {
		 			//빼줘야한다.
		 			int n=queueOne.poll();
		 			oneSum-=n;
		 			queueTwo.add(n);
		 			twoSum+=n;
		 			moveCount++;
		 		}else if(oneSum<longTarget) {
		 			int n=queueTwo.poll();
		 			twoSum-=n;
		 			queueOne.add(n);
		 			oneSum+=n;
		 			moveCount++;
		 		}
		 		
		 		
		 	}
		 	return -1;
		 	
	    }
	 
	 public boolean isEqualQueue(Queue<Integer> q1,Queue<Integer> q2) {
		 
		 
		 if(q1.size()!=q2.size()||!q1.contains(q2)) {
			 return false;
		 }
	
		 Queue<Integer> copyQ1=new LinkedList<Integer>(q1);
		 Queue<Integer> copyQ2=new LinkedList<Integer>(q2);

		 while(!copyQ1.isEmpty()) {
			 int a=copyQ1.poll();
			 int b=copyQ2.poll();
			 if(a!=b) {
				 return false;
			 }
		 }
		 return true;
	 }
}
