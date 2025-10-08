package 다리를지나는트럭_42583;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	
//	Solution s=new Solution();
//	int n=s.solution(2, 10, new int[] {7,4,5,6});
//System.out.println(n);
//}

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		
		//queueSum 큐에있는 합
		int queueSum=0;
		
		Queue<Truck> queue=new LinkedList<Solution.Truck>();
		
		int time=1;
		int index=0; // 트럭인덱스
		while(index<truck_weights.length) {
			//queue에서 빼기
			if(!queue.isEmpty() && time - queue.peek().insertTime == bridge_length) {
				Truck popTruck=queue.poll();
				queueSum-=popTruck.weight;
			}
			
			
			
			//queue 에 넣기
			if(queue.size()<bridge_length && queueSum+truck_weights[index] <=weight) {
				//넣을 수 있는 조건
				Truck truck=new Truck(time, truck_weights[index]);
				queueSum+=truck_weights[index];		
				index++;
				queue.add(truck);
			}
			
			time++;
		}
		
		//모든 트럭 넣었으면 끝날때까지 기다리기
		
		while(!queue.isEmpty()) {
			//queue에서 빼기
			if(time - queue.peek().insertTime == bridge_length) {
				Truck popTruck=queue.poll();
				
				if(queue.isEmpty()) {
					System.out.println(time);
					return time;
				}
			}
			time++;
		}
		
		return -1;
		
		
		
		
	}
	
	class Truck{
		int insertTime;
		int weight;
		public Truck(int insertTime,int weight) {
			this.insertTime=insertTime;
			this.weight=weight;
		}
	}

}
