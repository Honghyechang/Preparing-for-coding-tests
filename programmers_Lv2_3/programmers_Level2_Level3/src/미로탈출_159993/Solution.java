package 미로탈출_159993;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new String[] {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"});
//	}
	
	 class Position{
		 int y;
		 int x;
		 int step;
		 public Position(int y, int x, int step) {
			 this.y=y;
			 this.x=x;
			 this.step=step;
		 }
	 }
	 public int solution(String[] maps) {
	     
	        
	        boolean map[][]=new boolean[maps.length][maps[0].length()];
	        Position start=null;;
	        Position end=null;
	        Position laver=null;
	        
	        for(int i=0; i<maps.length; i++) {
	        	for(int j=0; j<maps[i].length(); j++) {
	        		char ch=maps[i].charAt(j);
	        		if(ch!='X') {
	        			map[i][j]=true;
	        		}
	        		
	        		if(ch=='S') {
	        			start=new Position(i, j, 0);
	        		}
	        		
	        		if(ch=='E') {
	        			end=new Position(i, j, 0);
	        		}
	        		
	        		if(ch=='L') {
	        			laver=new Position(i, j, 0);
	        		}
	        	}
	        }
	        
	        int answer=getAnswer(start,end,laver,map);
	        System.out.println(answer);
	        
	        return answer;
	 }
	 
	 public int getAnswer(Position start, Position end, Position laver , boolean map[][]) {
		 
		 //1번 start->Laver
		 int step1=startToEnd(start,laver,map);
		 if(step1==-1) {
			 return -1;
		 }
		 
		 //2번 Laber->end
		 int step2=startToEnd(laver,end,map);
		 if(step2==-1) {
			 return -1;
		 }
		// System.out.println("step1 : "+step1 + " , step2 : "+step2);
		 
		 return step1+step2;
		 
	 }
	 
	 public int startToEnd(Position start ,Position end ,  boolean map[][]) {
		 
		 boolean visited[][]=new boolean[map.length][map[0].length];
		 Queue<Position> queue=new LinkedList<Solution.Position>();
		 visited[start.y][start.x]=true;
		 queue.add(start);
		 
		 int dys[]= {1,-1,0,0};
		 int dxs[]= {0,0,1,-1};
		 
		 while(!queue.isEmpty()) {
			 Position position = queue.poll();
			 int y=position.y;
			 int x=position.x;
			 int nextStep= position.step + 1;
			 
			 for(int i=0; i<4; i++) {
				 int moveY=y+dys[i];
				 int moveX=x+dxs[i];
				 
				 if(moveY<0 || moveX <0|| moveY>=map.length || moveX>=map[0].length)continue;
				 
				 if(map[moveY][moveX] && !visited[moveY][moveX]) {
					 visited[moveY][moveX]=true;
					 Position p=new Position(moveY, moveX, nextStep);
					 queue.add(p);
					 
					 if(moveY==end.y && moveX==end.x) {
						 return nextStep;
					 }
				 }
			 }
			 
			 
		 }
		 
		 return -1;
		 
	 }

	 
 
}