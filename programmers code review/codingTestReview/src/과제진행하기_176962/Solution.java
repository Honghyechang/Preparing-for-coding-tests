package 과제진행하기_176962;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new String[][]{
//			  {"science", "12:40", "50"},
//			  {"music", "12:20", "40"},
//			  {"history", "14:00", "30"},
//			  {"computer", "12:30", "100"}
//			});
//	}
	
	
	public String[] solution(String[][] plans) {
		
		List<Study> planList=new ArrayList<Solution.Study>();
		
		for(int i=0; i<plans.length; i++) {
			String name=plans[i][0];
			String time=plans[i][1];
			String studyTime=plans[i][2];
			
			String timeSplit[]=time.split(":");
			
			Study study=new Study(name, Integer.parseInt(timeSplit[0]), Integer.parseInt(timeSplit[1]), Integer.parseInt(studyTime));
			planList.add(study);
		}
		
		Collections.sort(planList,(a,b)->{
			
			if(a.startHour==b.startHour) {
				return a.startMin-b.startMin;
			}
			return a.startHour-b.startHour;
			
		});
		
		Stack<Study> stack=new Stack<Solution.Study>();
		
		List<String> finished=new ArrayList<String>();
		
		
		for(int i=0; i<planList.size(); i++) {
			//다음작업이 없다면, i==size-1이라면 이 작업은 끝날때까지 그냥 다 한다.
			if(i==planList.size()-1) {
				finished.add(planList.get(i).name);
			}
			//현재 작업의 끝과 다음 작업의 시작을 비교한다.
			else {
				Study current=planList.get(i);
				Study next=planList.get(i+1);
				
				int currentFinishTime=current.startTime+current.studyTime;
				
				if(currentFinishTime==next.startTime) {
					//현재 작업은 끝나고 바로 다음으로 넘어간다~
					finished.add(current.name);
				}else if(currentFinishTime < next.startTime) {
					finished.add(current.name);
					//다음시간이 끝날때까지 계속 스택에서 꺼낸다.
					int remainTime=next.startTime-currentFinishTime;
				
						while(remainTime>0 && !stack.isEmpty()) {
							Study study=stack.pop();
							remainTime-=study.studyTime;
							if(remainTime>=0) {
								finished.add(study.name);
							}else {
								//remainTime이 0보다 작아졌다면
								//remainTime=2이고 study.studyTime이 5초라면
								//-3이 될텐데
								//실제로는 study는 2초만큼 수행한것일것이다.
								int realTime=remainTime+study.studyTime;
								study.updateStudyTime(study.studyTime-realTime);
								stack.push(study);
							}
						}
						
				}else if(currentFinishTime > next.startTime) {
					//한만큼 빼고 스택에다 넣기
					int workTime= next.startTime-current.startTime;
					current.updateStudyTime(current.studyTime-workTime);
					stack.push(current);
				}
				
			}

		}
		
		//남은스택이있다면
		while(!stack.isEmpty()) {
			finished.add(stack.pop().name);
		}
		
		
		
        String[] answer = finished.stream()
        						  .toArray(String[]::new);
        System.out.println(Arrays.toString(answer));
        return answer;
    }
	
	class Study{
		String name;
		int startHour;
		int startMin;
		int studyTime;
		int startTime;
		
		public Study(String name, int startHour, int startMin, int studyTime) {
			this.name=name;
			this.startHour=startHour;
			this.startMin=startMin;
			this.studyTime=studyTime;
			

			this.startTime=(startHour*60)+startMin;
		}
		
		public void updateStudyTime(int studyTime) {
			this.studyTime=studyTime;
		}
	}

}
