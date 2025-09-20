package 카페확장;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		s.solution(new int[] {5, 12, 30	}, new int[] {1, 2, 0, 1},10);
//
//	}

	public int solution(int[] menu, int[] order, int k) {
		
		
		int customerMax=order.length-1;// 0 ,1 ,2 ,3번째 손님까지원한다.
		int currentCustomer=0; //첫번째 손님
		int max=Integer.MIN_VALUE;
		
		int time=0;
		Queue<Integer> queue=new LinkedList<Integer>();
		queue.add(order[currentCustomer]); 
		if(order.length==1) {
			return 1;
		}
		//40초가 된 이후에는 상관이없다라는 것
		//현재 시간을 40/10 했을때 4가 들어왔을때 이후는 따로 계산할 필요가없다.
		//처리한 사람만 따져보자.
		
		while(currentCustomer!=customerMax) {
			if(queue.isEmpty()) {
				//time에서 가장 가까운애를 넣기
				currentCustomer++;
				time=k*currentCustomer;
				queue.add(order[currentCustomer]);
				
				continue;
			}
			int queueOrder=queue.poll();
			time+=menu[queueOrder];
			
			
			
			//currentCustomer 0 , 1 ,2 ,3
			int requireCustomer=(time/k); //22초 / 10 = 2번째 손님까지 즉, 0 ,1 ,2손님까지 원한다!  but 지금까지 처리한 사람이 1명이라면
			if(requireCustomer>customerMax) {
				requireCustomer=customerMax;
			}
			//i가 1
			for(int i=currentCustomer+1;i<=requireCustomer; i++) {
				queue.add(order[i]);
				currentCustomer++;
			}
			int qCount=time%k==0?queue.size():queue.size()+1;
			if(qCount>max) {
				max=qCount;
			}
			
		}
		System.out.println(max);
		return max;
    }
}
