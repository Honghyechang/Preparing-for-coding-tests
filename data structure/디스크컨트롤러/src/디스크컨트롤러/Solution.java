package 디스크컨트롤러;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

//	public static void main(String[] args) {
//
//		Solution s=new Solution();
//		int n=s.solution(new int[][] {{0,3},{1,9},{2,6}});
//System.out.println(n);
//	}
//	
	public int solution(int[][] jobs) {
		//시작시점에서 가장 짧은 작업부터 먼저한다.
		PriorityQueue<Task> tasks=new PriorityQueue<Task>(
				(a,b)->{
					return a.taskTime-b.taskTime;
				}
		);
		
		int taskCount=0;
		int time=0;
		
		List<Task> taskList=new ArrayList<Task>();
		
		for(int i=0; i<jobs.length; i++) {
			taskList.add(new Task(jobs[i][0],jobs[i][1]));
		}
		
		boolean tasking=false; //작업중인지
		
		Task currentTask=null;
		int currentTaskTime=0;
		int sum=0;
		
		int queueCount=0;
		
		
		while(taskCount!=jobs.length) {
			//System.out.println("===="+time+"====");
			if(queueCount!=jobs.length) {
				for(int j=0; j<taskList.size();j++) {
					Task t=taskList.get(j);
					if(t.requestTime==time) {
						tasks.add(t);
						queueCount++;
						//System.out.println(time+"일 때"+"["+t.requestTime+","+t.taskTime+"] 우선순위 큐 추가");
					}
				}
			}
			
			//작업이 끝
			if(tasking&&currentTask.taskTime==currentTaskTime) {
				//System.out.println(time+" 초 ["+currentTask.requestTime+","+currentTask.taskTime+"]  작업끝");
				int total=time-currentTask.requestTime;
				sum+=total;
				tasking=false;
				currentTask=null;
				taskCount++;
				
			}
			
			if(!tasking) {
				if(tasks.size()==0) {
					time++;
					continue;
				}
				Task t=tasks.poll();
				currentTask=t;
				currentTaskTime=0;
				tasking=true;
			}
			time++;
			currentTaskTime++;
			
			
		}
		
		float answer=sum/jobs.length;
		return (int)answer;
    }
	
	class Task{
		public int requestTime;
		public int taskTime;
		
		public Task(int requestTime, int taskTime) {
			this.requestTime=requestTime;
			this.taskTime=taskTime;
		}
	}

}
