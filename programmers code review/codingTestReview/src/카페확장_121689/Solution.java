package 카페확장_121689;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
////	s.solution(new int[] {5, 12, 30	}, new int[] {2, 1, 0,0,0,1, 0},10);
//	s.solution(new int[] {5	}, new int[] {0,0,0,0,0},5);
//
//}

public int solution(int[] menu, int[] order, int k) {
	
	
	//처리한 초 일때, 몇명이 추가되었는지
	//만약 그게 10단위라면 1명빼기
	int max=Integer.MIN_VALUE;
	int time=0;
	//나빼기 1초전에 몇명인지 세기
	Queue<Integer> queue=new LinkedList<Integer>();

	int processCount=1;
	queue.add(menu[order[0]]);
	
	while(processCount!=order.length) {
		
			if(queue.isEmpty()) {
				
				time=processCount*k;
				queue.add(menu[order[processCount]]);
				processCount++;
				
			}
		
		    time+=queue.peek();
			
			//time -1 초에 해당하는 애들 넣기
			int targetIndex=(time-1)/k;
			if(targetIndex > order.length-1) {
				targetIndex=order.length-1;
			}
			for(int i=processCount; i<=targetIndex; i++) {
				
				queue.add(menu[order[i]]);
				processCount++;
				System.out.println("입장 : "+processCount+" 번");
			}
			
			if(max<queue.size()) {
				max=queue.size();
			}
		
		
		    queue.poll();
		
		
		
	}
	System.out.println(max);
	return max;
	
}

}
