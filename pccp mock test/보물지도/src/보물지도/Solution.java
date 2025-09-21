package 보물지도;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Solution s=new Solution();
	s.solution(4,4,new int[][] {{2, 3}, {3, 3}});

}
	
	  public int solution(int n, int m, int[][] hole) {
		  
	        int answer = bfs(n,m,hole);
	        System.out.println(answer);
	        return answer;
	    }

	  public int bfs(int n, int m,int[][]hole)
	  {
		  //n,m 에 0은 아이템 안쓴 것!, 1은 아이템 쓴것!
		  boolean visited[][][]=new boolean[n][m][2];
		  // (n,m)으로 통일 할것이다.
		  //nonMoveableList에 포함되면 거기는 못간다!
		  boolean[][] nonMoveableList=new boolean[n][m];
		  for(int i=0; i<hole.length; i++) {
			  int x=hole[i][0]-1;
			  int y=hole[i][1]-1;
			  nonMoveableList[x][y]=true; //true면못간다~
			  
			  
		  }
		  
		  //목적지는 (n-1,m-1)
		  //시작은 0,0,0
		  Point start=new Point(0,0,0, false);
		  Queue<Point> queue=new LinkedList<Solution.Point>();
		  queue.add(start);
		  visited[0][0][0]=true;
		  
		  int dxs[]= {0,0,1,-1};
		  int dys[]= {-1,1,0,0};
		  
		  
		  while(!queue.isEmpty()) {
			  Point point=queue.poll();
			  int nextStep=point.step+1;
		//	  System.out.println("point.x :"+point.x+" point.y : "+point.y );
			  int x=point.x;
			  int y=point.y;

			  boolean itemUse=point.itemUse;
		//	  System.out.println("("+x+","+y+") item사용:"+itemUse+" 조사 시작");
			  
			  
			  if(itemUse) {
				  // +1칸은 가능
				  for(int i=0; i<4; i++) {
					  int changeX=x+dxs[i];
					  int changeY=y+dys[i];
					  
					  if(changeX<0 || changeX>=n || changeY<0 || changeY>=m) continue;
					  if(!visited[changeX][changeY][1]&&!nonMoveableList[changeX][changeY]) {
						  Point newPoint=new Point(changeX,changeY,nextStep,true);
						  visited[changeX][changeY][1]=true;
						  queue.add(newPoint);
						  
						  
						  if(changeX==n-1 && changeY==m-1) {
							  return nextStep;
						  }
						  
						  
					  }
				  }
			  }else {
				  
				  //1칸
				  for(int i=0; i<4; i++) {
					  int changeX=x+dxs[i];
					  int changeY=y+dys[i];
					  
					  if(changeX<0 || changeX>=n || changeY<0 || changeY>=m) continue;
					  if(!visited[changeX][changeY][0]&&!nonMoveableList[changeX][changeY]) {
						  Point newPoint=new Point(changeX,changeY,nextStep,false);
						  visited[changeX][changeY][0]=true;
						  queue.add(newPoint);
						  
						  if(changeX==n-1 && changeY==m-1) {
							  return nextStep;
						  }
					  }
				  }
				  
				  
				  
				  //2칸
				  //아이템을 쓰는경우가 된다.
				  for(int i=0; i<4; i++) {
					  int changeX=x+(2*dxs[i]);
					  int changeY=y+(2*dys[i]);
					  
					  if(changeX<0 || changeX>=n || changeY<0 || changeY>=m) continue;
					  if(!visited[changeX][changeY][1]&&!nonMoveableList[changeX][changeY]) {
						  Point newPoint=new Point(changeX,changeY,nextStep,true);
						  visited[changeX][changeY][1]=true;
						  queue.add(newPoint);
						  
						  if(changeX==n-1 && changeY==m-1) {
							  return nextStep;
						  }
					  }
				  }
				  
				  
				  
			  }
		  }
		  
		  
		  
		  return -1;
		  
	  
	  }
	  
	  class Point{
		  int x,y,step;
		  boolean itemUse;
		  
		  public Point(int x,int y,int step,boolean itemUse) {
			  this.x=x;
			  this.step=step;
			  this.y=y;
			  this.itemUse=itemUse;
		  }
	  }
}
