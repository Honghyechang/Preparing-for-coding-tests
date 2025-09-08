package 게임맵최단거리;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}});
//	}

	 public int solution(int[][] maps) {
		 	
	        int answer = dfs(maps);
	        System.out.println(answer);
	        return answer;
	 }
	 
	 public int dfs(int [][]maps) {
		 
		 int xSize=maps.length; //5
		 int ySize=maps[0].length;//5
		 
		 
		// Set<String> moveable=new HashSet<String>();
		 boolean [][] visit=new boolean[maps.length][maps[0].length];
		// System.out.println(visit[0][3]);
		 
		// mapReset(maps,moveable);
		 
		 Move startMove=new Move(0, 0, 1);
		 Queue<Move> queue=new LinkedList<Solution.Move>();
		 queue.add(startMove);
		 visit[0][0]=true;
		 
		 int dx[]= {-1 , 1, 0 ,0};
		 int dy[]= {0,0,-1,1};
		 
		 
		 // x ,y ( 0 , 0)
		 // x는 세로로 이동 배열이기때문
		 // y는 가로 이동 배열이기 때문  좌표랑은 다름
		 
		 while(!queue.isEmpty()) {
			 Move move=queue.poll();
			 int x=move.x;
			 int y=move.y;
			 int step=move.step;
			 
			 for(int i=0; i<4; i++) {
				 int moveX=x+dx[i];
				 int moveY=y+dy[i];
				 
				 if(moveX<0 || moveX >= xSize || moveY < 0 || moveY >=ySize){
					 continue;
				 }
				 
				 if(!visit[moveX][moveY] && maps[moveX][moveY]==1) {
					 queue.add(new Move(moveX,moveY,step+1));
					 visit[moveX][moveY]=true;
					 if(moveX==maps.length-1 && moveY==maps[0].length-1) {
						 return step+1;
					 }
				 }
			 }
			 
			 
		 }
		 
		 return -1;
		 
		 
	 }
	 
	 class Move{
		 int x,y,step;
		 public Move(int x, int y, int step) {
			 this.x=x;
			 this.y=y;
			 this.step=step;
		 }
	 }
	 
	 public void mapReset(int[][] maps, Set<String> moveable) {
		 for(int i=0; i<maps.length; i++) {
			 for(int j=0; j<maps[i].length; j++) {
				 if(maps[i][j]==1) {
					 moveable.add(i+","+j);
				 }
			 }
		 }
	 }
}
