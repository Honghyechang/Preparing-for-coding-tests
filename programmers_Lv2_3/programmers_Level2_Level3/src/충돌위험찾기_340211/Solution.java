package 충돌위험찾기_340211;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution(new int[][] {{3,2},{6,4},{4,7},{1,4}}, new int[][] {{4,2},{1,3},{4,2},{4,3}});
//}

	Map<String,Integer> recordRoute=new HashMap<String, Integer>();

  public int solution(int[][] points, int[][] routes) {

	  //r  >>> c
	  //step, start ,end 를 보낸다.
	  int [][] pointArr=new int[points.length][points[0].length];
	  int [][] routesArr=new int[routes.length][routes[0].length];
	  
	  for(int i=0; i<pointArr.length; i++) {
		  for(int j=0; j<pointArr[i].length; j++) {
			  pointArr[i][j]=points[i][j]-1;
		  }
	  }
	  
	  for(int i=0; i<routes.length; i++) {
		  for(int j=0; j<routes[i].length; j++) {
			  routesArr[i][j]=routes[i][j]-1;
		  }
	  }
	  
	  for(int i=0; i<routesArr.length; i++) {
		  int route[]=routesArr[i];
		  int step=0;
		 
		  for(int j=0; j<route.length-1; j++) {
			//  System.out.println(route[j] +" ->"+route[j+1]);
			  int start[]=pointArr[route[j]];
			  int end[]=pointArr[route[j+1]];
			  //System.out.println("start ("+start[0]+","+start[1]+") ,"+"end ("+end[0]+","+end[1]+")");
			  step=makeRoute(step,start,end);
		  }
	  }
	  
	  int answer=0;
	  for(String key : recordRoute.keySet()) {
		  if(recordRoute.get(key) >= 2) {
			  answer++;
		  }
	  }
	  
	  System.out.println("정답 "+answer);
	 return answer;
	 
	 
	  
  }
  
  public int makeRoute(int step, int start[], int end[]) {
	  
	  boolean visited[][]=new boolean[100][100];
	  Position startPosition=new Position( start[0], start[1],step, null);
	
	  if(step!=0) {
		  startPosition.setBefore(startPosition);
	  }
	  
	  Queue<Position> queue=new LinkedList<Position>();
	  queue.add(startPosition);
	  visited[startPosition.y][startPosition.x]=true;
	  
	  int dys[]= {1,-1,0,0};
	  int dxs[]= {0,0,-1,1};
	  while(!queue.isEmpty()) {
		  Position p=queue.poll();
		  int y=p.y;
		  int x=p.x;
		  int nextStep=p.step+1;
		  
		  for(int i=0; i<4; i++) {
			  int moveY=y+dys[i];
			  int moveX=x+dxs[i];
			  
			  if(moveX<0 || moveY<0 || moveX>=100 || moveY >=100) continue;
			  if(!visited[moveY][moveX]) {
				  visited[moveY][moveX]=true;
				  Position moveP=new Position(moveY, moveX, nextStep, p);
				  if(moveP.y==end[0] && moveP.x==end[1]) {
					  moveP.getRecord();
					  //System.out.println();
					//  System.out.println();
					  return nextStep;
				  }
				  queue.add(moveP);
			  }
			  
		  }
		  
	  }
	  return -1;
	  
	  
	  
	  
	  //step을 리턴
  }
  
  class Position
  {
	  int y;
	  int x;
	  int step;
	  Position before;
	  
	  public Position(int y,int x, int step, Position before) {
		  this.y=y;
		  this.x=x;
		  this.step=step;
		  this.before=before;
	  }
	  
	  public void getRecord() {
		  if(this==before)return;
		 
		  recordRoute.merge(this.y+","+this.x+","+this.step, 1, (a,b)->a+b);
		 // System.out.println(this.y+","+this.x+","+this.step + " : " +recordRoute.get(this.y+","+this.x+","+this.step));
		  if(this.before==null) {
			  return;
		  }
		  this.before.getRecord();
	  }
	  
	  public void setBefore(Position p) {
		  this.before=p;
	  }
	  
	 
	  
  }
}
