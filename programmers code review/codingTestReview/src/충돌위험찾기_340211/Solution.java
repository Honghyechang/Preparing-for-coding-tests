package 충돌위험찾기_340211;

//import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class Solution {
	
	Map<Point,Integer> maps=new HashMap<Point,Integer>();
	int answer=0;

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution(new int[][] {{2,2},{2,3},{2,7},{6,6},{5,2}}, new int[][] {{2,3,4,5},{1,3,4,5}});
//	}
//	

	  public int solution(int[][] points, int[][] routes) {
		  
		  	for(int i=0; i<routes.length; i++) {
		  		int route[]=routes[i];
		  		recursion(points,route,0,1,0);
		 // 	System.out.println("=============");	
		  	}
		  
		  	for(Point p : maps.keySet()) {
		  		int value=maps.get(p);
		  		if(value>=2) {
		  		//	System.out.println(p.y + " , "+p.x+" 일때 value : "+value );
		  			answer++;
		  		}
		  	}
		  	System.out.println(answer);
		  	return answer;
	   }
	  
	  public int makeRoute(int startY,int startX , int endY, int endX,int nextStep,boolean isStart) {
		  boolean visited[][]=new boolean[101][101];
		  
		  int currentStep=nextStep;
		  
		  Point first=new Point(startY, startX, currentStep);
		  first.setBeforePoint(null);
		  Queue<Point> queue=new LinkedList<Solution.Point>();
		 
		  queue.add(first);
		  visited[startY][startX]=true;
		  
//		  if(sets.contains(first)) {
//			  answer++;
//		  }else {
//			  sets.add(first);
//		  }
		  
		 // System.out.println("====="+startY+","+startX + "->" +endY+","+endX+" step : "+nextStep+"시작======");
		  
		  while(!queue.isEmpty()) {
			  Point point=queue.poll();
			  int y=point.y;
			  int x=point.x;
			  int step=point.step;
			  
			  
			
			
			  //r을 먼저 이동하니까 
			  //세로를 먼저 이동 y를 먼저 이동
			  
			  int dys[]= {-1,1,0,0};
			  int dxs[]= {0,0,-1,1};
			  
			  for(int i=0; i<4; i++) {
				  int newY=y+dys[i];
				  int newX=x+dxs[i];
				  
				  if(newY >100 || newY <0 || newX >100 || newX<0 ) {
					  continue;
				  }
				  if(!visited[newY][newX]) {
					  Point p=new Point(newY, newX, step+1);
					  p.beforePoint=point;
					  visited[newY][newX]=true;
					  queue.add(p);
					  
					
//					  if(sets.contains(p)) {
//						  System.out.println("겹침");
//						  answer++;
//					  }else {
//						  sets.add(p);
//					  }
					  
					  
					  if(newY==endY && newX==endX) {
						  currentStep=p.step;
						  //System.out.println("최종루트");
						  //before이 null일때까지 set에 담기
						  while(p!=null) {
						//	  System.out.println(p.y+","+p.x+" step: "+p.step+"  =>");
							  
							  if(!isStart && p.beforePoint==null) {
								  break;
							  }
							  maps.merge(p, 1, (a,b)->a+b);
							  
							  p=p.beforePoint;
						  }
						//  System.out.println("\n\n");
						  
						  break;
					  }
					  
					  
				  }
				  
			  }
			  
			  
			  
			  
		  }
		  
		  return currentStep;
		  
	  }
	  
	  
	  public void recursion(int[][] points,int route[],int start, int end, int step) {
		  
		  //4라면 3번 호출받아야한다.
		  //0 , 1, 2, 3이면 취소
		  if(start==route.length-1) {
			  return;
		  }
		  int startPositon=route[start]-1; 
		  int endPositon=route[end]-1; 
		  
		  int startY=points[startPositon][0];
	  	  int startX=points[startPositon][1];
	  	  int endY=points[endPositon][0];
	  	  int endX=points[endPositon][1];
		  
	  	  
	     int nextStep=makeRoute(startY,startX,endY,endX,step,start==0?true : false);
	     recursion(points,route,start+1,end+1,nextStep);
		  
		  
	  }
	  
	  
	  
	  
	  class Point{
		  int y;
		  int x;
		  int step;
		  
		  Point beforePoint;
		  public Point(int y,int x,int step) {
			  this.x=x;
			  this.y=y;
			  this.step=step;
		  }
		  
		  public void setBeforePoint(Point p ) {
			  this.beforePoint=p;
		  }
		  
		  @Override
		public boolean equals(Object obj) {
			Point p=(Point)obj;
			return p.x==this.x && p.y==this.y && p.step==this.step;
		}
		  
		  @Override
		public int hashCode() {
			return Objects.hash(y,x,step);
		}
		  
	  }
}
