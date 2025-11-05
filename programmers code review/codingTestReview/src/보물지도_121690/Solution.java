package 보물지도_121690;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
//	s.solution(5,4,new int[][] {{1, 4}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {3, 3}, {4, 1}, {4, 3}, {5, 3}});
//
//}
	
	  public int solution(int n, int m, int[][] hole) {
		  
		  int answer=bfs(n,m,hole);
		  System.out.println(answer);
		
		return answer;
	  }
	  
	  
	  public int bfs(int n,int m,int [][]hole) {
		  
		  boolean gameMap[][]=new boolean[m][n];
		  for(int h[] : hole) {
			  int a=h[0]-1;
			  int b=h[1]-1;
			  gameMap[b][a]=true;
		  }
		  
		  //visited[0][x][y] 0은 아이템을 쓰지 않은상태
		  //visited[1][][] 1은 아이템을 쓴 상태
		  boolean visited[][][]=new boolean[2][m][n];
		  
		  
		  int targetY=m-1;
		  int targetX=n-1;
		  	
		  Queue<Position> queue=new LinkedList<Solution.Position>();
		  
		  Position start=new Position(0, 0, false, 0);
		  visited[0][0][0]=true;
		  queue.add(start);
		  
		  int dys[]= {1,-1,0,0};
		  int dxs[]= {0,0,1,-1};
		  

		  int itemDys[]= {2,-2,0,0};
		  int itemDxs[]= {0,0,2,-2};
		  
		  while(!queue.isEmpty()) {
			  Position position=queue.poll();
			  
			  int y=position.getY();
			  int x=position.getX();
			  int nextStep=position.getStep()+1;
			  boolean usedItem=position.getUsedItem();
			  
			//  System.out.println("step : "+position.getStep()+" y : "+y +" x: "+x+" item : "+usedItem);
			  
			  //아이템을 쓴상태라면 1칸씩만 가능
			  if(usedItem) {
				  
				  for(int i=0; i<4; i++) {
					  
					  int moveY=y+dys[i];
					  int moveX=x+dxs[i];
					  
					  if(moveY<0 || moveY>=m || moveX < 0 || moveX >= n) {
						  continue;
					  }
					  
					  if(!visited[1][moveY][moveX] && !gameMap[moveY][moveX]) {
						  //이동가능
						  visited[1][moveY][moveX]=true;
						  Position movePosition=new Position(moveY, moveX, true, nextStep);
						  if(moveY==targetY && moveX==targetX) {
							  return nextStep;
						  }
					
						  queue.add(movePosition);
					  }
					  	  
				  }
				  
				  
			  }
			  
			  else {
				  
				  //아이템을 안썻을경우에는
				  //안쓰고 가는경우와 
				  //쓰고 가는 경우로 나뉜다.
				  
				  
				  //안쓰고 한칸씩 가는 경우
				  	for(int i=0; i<4; i++) {
					  
					  int moveY=y+dys[i];
					  int moveX=x+dxs[i];
					  
					  if(moveY<0 || moveY>=m || moveX < 0 || moveX >= n) {
						  continue;
					  }
					  
					  if(!visited[0][moveY][moveX] && !gameMap[moveY][moveX]) {
						  //이동가능
						  visited[0][moveY][moveX]=true;
						  Position movePosition=new Position(moveY, moveX, false, nextStep);
						  if(moveY==targetY && moveX==targetX) {
							  return nextStep;
						  }
					
						  queue.add(movePosition);
					  }
					  	  
				  }
				  	
				  	
				  	//쓰고 2칸씩 가는경우
				  	for(int i=0; i<4; i++) {
						  
						  int moveY=y+itemDys[i];
						  int moveX=x+itemDxs[i];
						  
						  if(moveY<0 || moveY>=m || moveX < 0 || moveX >= n) {
							  continue;
						  }
						  
						  if(!visited[1][moveY][moveX] && !gameMap[moveY][moveX]) {
							  //이동가능
							  visited[1][moveY][moveX]=true;
							  Position movePosition=new Position(moveY, moveX, true, nextStep);
							  if(moveY==targetY && moveX==targetX) {
								  return nextStep;
							  }
						
							  queue.add(movePosition);
						  }
						  	  
					  }
				  
				  
				  
				  
				  
			  }
			 
			  
			  
			  
			  //아이템을 쓴상태가 아니라면 2칸도 이동가능
			  
			  
			  
		  }
		  
		  
		  
		  
		  
		  
		  
		  return -1;
	  }

	  class Position{
		  int y;
		  int x;
		  boolean usedItem;
		  int step;
		  public Position(int y, int x , boolean usedItem, int step) {
			  this.y=y;
			  this.x=x;
			  this.usedItem=usedItem;
			  this.step=step;
		  }
		  public int getY() {
			  return this.y;
		  }

		  public int getX() {
			  return this.x;
		  }

		  public int getStep() {
			  return this.step;
		  }

		  public boolean getUsedItem() {
			  return this.usedItem;
		  }
	  }
	  
}
