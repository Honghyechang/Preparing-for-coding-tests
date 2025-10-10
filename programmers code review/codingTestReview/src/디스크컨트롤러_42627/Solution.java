package 디스크컨트롤러_42627;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

//	public static void main(String[] args) {
//
//		Solution s=new Solution();
//		int n=s.solution(new int[][] {{0,3},{1,9},{2,6}});
//System.out.println(n);
//	}
	
	public int solution(int[][] jobs) {
		
		int time=0;
//		int workCount=0;
		
		List<Job> remain = new ArrayList<Job>();
		List<Job> remove = new ArrayList<Job>();
		
		Queue<Job> queue=new PriorityQueue<Job>((a,b)->a.workTime-b.workTime);
		
		for(int i=0; i<jobs.length; i++) {
			Job j=new Job(jobs[i][0], jobs[i][1]);
			remain.add(j);
		}
		
		Collections.sort(remain,(a,b)->a.requestTime-b.requestTime);
		
		boolean isWorking=false;
		Job currentWork=null;
		int currentStartTime=-1;
		
		
		int processCount=0;
		
		int resultSum=0;
		while(processCount<jobs.length) {
		
			//작업완료
			if(isWorking && time==currentStartTime+currentWork.workTime) {
				resultSum+=(time-currentWork.requestTime);
				isWorking=false;
				currentWork=null;
				currentStartTime=-1;
				
				
				
			}
			
			for(int i=0; i<remain.size(); i++) {
				if(remain.get(i).requestTime>time)break;
				remove.add(remain.get(i));
			}
			
			for(Job job : remove) {
				queue.add(job);
			}
			
			remain.removeAll(remove);
			remove.clear();
			
			if(isWorking==false && queue.size()>0) {
				isWorking=true;
				currentWork=queue.poll();
				currentStartTime=time;
				processCount++;
			}
			//System.out.println("time : "+time+" 일때 isworking : "+isWorking+" ("+currentWork.requestTime+","+currentWork.workTime+")");
			time++;

		}
		
		//마지막 작업 +1 해주기
		time=time-1+currentWork.workTime;
		
		resultSum+=(time - currentWork.requestTime);
		int result= (int)((double)resultSum/jobs.length);
		
		//System.out.println("총 time : "+time + "resultSum : "+resultSum + "result : "+result);
		return result;
		
	}
	
	class Job{
		int requestTime;
		int workTime;
		public Job(int requestTime,int workTime) {
			this.requestTime=requestTime;
			this.workTime=workTime;
		}
	}

}
