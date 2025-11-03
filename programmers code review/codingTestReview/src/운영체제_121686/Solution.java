package 운영체제_121686;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution(new int[][] {{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}});
//}

 public long[] solution(int[][] program) {
	 List<Program> programList=new ArrayList<Solution.Program>();
	 for(int p[] : program) {
		 Program pro=new Program(p[0], p[1], p[2]);
		 programList.add(pro);
	 }
	 
	 Collections.sort(programList,(a,b)->a.startTime-b.startTime);
	 
	 
	 Queue<Program> queue=new PriorityQueue<Solution.Program>(
			 
			 (p1,p2)->{
				 
				 if(p1.priority==p2.priority) {
					 return p1.startTime-p2.startTime;
				 }
				 
				 return p1.priority-p2.priority;
			 }
			 
	);
	 
	 int time=programList.get(0).startTime;
	 
	 
	 
	 int task=0;
	 int target=program.length;
	// List<Program> remove=new ArrayList<Solution.Program>();
	 
	 int index=0;
	 
	 long answer[]=new long[11];
	 
	 while(task!=target) {
		
		 
		 int startIndex=index;
		 for(int i=startIndex; i<programList.size(); i++) {
			 
			 Program p = programList.get(i);
			 if(p.startTime > time)break;
			 
			 index++;
			 queue.add(p);
			 
		 }
		 
	
		 
		 
		 if(!queue.isEmpty()) {
			 //현재 작업할 것을 가져온다.
			 Program current=queue.poll();
			 //대기시간을 구한다.
			 current.setWaitTime(time);
			 answer[current.priority]+=current.waitTime;
			 
			 //다 처리후 time을 업데이트한다.
			 time=time+current.processTime;
			 
			 task++;
			 
		 }else {
			 //만약에 비어있는 경우라면 time을 하나씩 증가할 수 없으니까 가장 빠른 타임으로 넘겨버린다.
			 time=programList.get(index).startTime;
		 }
		 
	 }
			 
     answer[0]=time;


	 System.out.println(Arrays.toString(answer));
	 return answer;
 }
 
 class Program{
	 int priority;
	 int startTime;
	 int processTime;
	 int waitTime;
	 
	 public Program(int priority,int startTime,int processTime) {
		 this.priority=priority;
		 this.startTime=startTime;
		 this.processTime=processTime;
	 }
	 
	 public void setWaitTime(int currentTime) {
		 this.waitTime=currentTime-startTime;
	 }
 }
 
 
}
