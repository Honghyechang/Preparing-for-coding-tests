package 운영체제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//	Solution s=new Solution();
//	s.solution(new int[][] {{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}});
//	}
	
	 public long[] solution(int[][] program) {
		 
		 Queue<Task> queue = new PriorityQueue<Task>((a,b) -> {
			    if(a.priority != b.priority) return a.priority - b.priority;
			    return a.startTime - b.startTime; // 같은 우선순위면 호출시간 순
			});
		 int totalTask=program.length;
		 
		 int time=0;
		 
		 List<Task> taskList=new ArrayList<Task>();
		 for(int i=0; i<totalTask; i++) {
			 Task task=new Task(program[i][0],program[i][1],program[i][2]);
			 taskList.add(task);
		 }
		 //taskList=taskList.stream().sorted((a,b)->a.startTime-b.startTime).collect(Collectors.toList());

		 
		 long answer[]=new long[11];
		 Task pickTask=null;
		
		 
		 while(totalTask>0) {
			 //time에 호출된 task들을 가져온다.			 
			 taskList=insertQueue(taskList,queue,time);
			 
			  
			 if(queue.size()==0) {
				 
				 //time은 +1일씩 증가하지말고
				 //가장 가까운 타임에 있는것으로 접근
				 List<Task> nearList=taskList.stream()
				 		 .sorted((a,b)->a.startTime-b.startTime)
				 		 .collect(Collectors.toList());
				 
				 for(Task near : nearList ) {
					 if(time<near.startTime) {
						 time=near.startTime;
						 break;
					 }
				 }
				 
				 continue;
			 }
			 
			 pickTask=queue.poll();
			 answer[pickTask.priority]+=time-pickTask.startTime;
	    	 time=time+pickTask.taskTime;
	    	 totalTask--;

			 
		 }
		
		// System.out.println(time);
		 answer[0]=time;
		 System.out.println(Arrays.toString(answer));
	      return answer;
	   }
	 
	 public List<Task> insertQueue(List<Task> list,Queue<Task> queue,int time){
		 List<Task> copyList=new ArrayList<Solution.Task>(list);
	
		 for(Task task : list) {
			 if(time>=task.startTime) {
				 queue.add(task);
				
				 copyList.remove(task);
			 }
		 }
		 return copyList;
	 }

	 class Task{
		 int priority;
		 int taskTime;
		 int startTime;
		 int realStart;
		 public Task(int priority,int startTime ,int taskTime) {
			 this.priority=priority;
			 this.taskTime=taskTime;
			 this.startTime=startTime;
		 }
		 public void setRealStart(int realStart) {
			 this.realStart=realStart;
		 }
	 }
}
