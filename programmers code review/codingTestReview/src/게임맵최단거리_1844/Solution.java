package 게임맵최단거리_1844;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
//
//		public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
//	}

	 public int solution(int[][] maps) {
		 boolean visited[][]=new boolean[maps.length][maps[0].length];
		 Position first=new Position(0, 0, 1);
		 visited[0][0]=true;
		 
		 Queue<Position> queue=new LinkedList<Solution.Position>();
		 queue.add(first);
		 
		 int dys[]= {0,0,1,-1};
		 int dxs[]= {1,-1,0,0};
		 
		 while(!queue.isEmpty()) {
			 
			 Position p=queue.poll();
			 int nextStep=p.step+1;
			 
			 for(int i=0; i<4; i++) {
				 int moveY=p.y + dys[i];
				 int moveX=p.x+dxs[i];
				 
				 if(moveX < 0 || moveY < 0 || moveX >= maps[0].length || moveY >= maps.length)continue;
				 if(!visited[moveY][moveX] && maps[moveY][moveX]==1) {
					 if(moveY==maps.length-1 && moveX==maps[0].length-1) {
						 System.out.println(nextStep);
						 return nextStep;
					 }
					 
					 Position moveP=new Position(moveY, moveX, nextStep);
					 visited[moveY][moveX]=true;
					 queue.add(moveP);
					 
					 
				 }
			 }
			 
			 
		 }
		 
		 System.out.println("-1");
		 return -1;
		 
	 }
	 
	 class Position{
		 int y;
		 int x;
		 int step;
		 public Position(int y,int x, int step) {
			 this.y=y;
			 this.x=x;
			 this.step=step;
		 }
		 
	 }
}
