package 기능개발_42586;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//Solution s=new Solution();
//int n[]=s.solution(new int[] {95,90,99,99,80,99}, new int[] {1,1,1,1,1,1});
//System.out.println(Arrays.toString(n));
//}

  public int[] solution(int[] progresses, int[] speeds) {
	  
	  Queue<Point> queue=new LinkedList<Solution.Point>();
	  
	  List<Integer> answerList=new ArrayList<Integer>();
	  
	  
	  for(int i=0; i<progresses.length; i++)
	  {
		  int process =progresses[i];
		  int speed=speeds[i];
		  Point p= new Point(process, speed);
		  
		  queue.add(p);
	  }
	  
	  int day=1;
	  while(!queue.isEmpty()) {
		  Point firstPoint=queue.poll();
		  while(true) {
			  if((day*firstPoint.speed) + firstPoint.process >=100) {
				  break;
			  }
			  day++;
		  }
		  
		  int count=1;
		  if(queue.isEmpty()) {
			  answerList.add(count);
			  break;
		  }
		  while(!queue.isEmpty()) {
			  
			  Point peekPoint=queue.peek();
			  if((day*peekPoint.speed) + peekPoint.process >=100) {
				  queue.poll();
				  count++;
			  }else {
				  break;
			  }
		  }
		  
		  answerList.add(count);
	  }
	  
	  int answer[]=answerList.stream()
			  				 .mapToInt(i-> i.intValue())
			  				 .toArray();
	  System.out.println(Arrays.toString(answer));
	  return answer;
	  
	  
  }
  
  class Point{
	  int process;
	  int speed;
	  public Point(int process, int speed) {
		  this.speed=speed;
		  this.process=process;
		  
	  }
  }

}
