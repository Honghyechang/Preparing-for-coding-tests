package 석유시츄_250136;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s=new Solution();
		s.solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}});
		
	}
	
	 public int solution(int[][] land) {
	        int answer = bfs(land);
	        System.out.println(answer);
	        
	        return answer;
	  }
	 
	 public int bfs(int[][] land) {
		 
		 boolean visited[][]=new boolean[land.length][land[0].length];
		 //총 열의 개수만큼 시도해볼것
//		 System.out.println("처음");
//		 for(int u=0; u<land.length; u++) {
//			 for(int f=0; f<land[u].length; f++) {
//				 System.out.print(land[u][f] + " ");
//			 }
//			 System.out.println();
//		 }
		 
		//points는 뚫린 부분을 의미
		 List<Point> points=new ArrayList<Point>();
		 int dxs[]= {0,0,-1,1};
		 int dys[]= {-1,1,0,0};
		 
		 int max=Integer.MIN_VALUE;
		 for(int i=0; i<land[0].length; i++) {
			 
			// System.out.println(i+"열 뚫기 단계");

			 int assureX=i;
			 int assureY=-1;
			 // i->x j->y
			 //x가 0일때 y~쫙
			 for(int j=0; j<land.length; j++) {
				 assureY=j;
				 
				 if(land[j][i]==0) {
					 land[j][i]=2; //2
					 Point p=new Point(j, i,true);
					 points.add(p);
				 }
			 }
			 
			 //무조건 assureX,assureY를 지나가니까 이것을 시작으로 둔다.
			 Queue<Point> queue=new LinkedList<Solution.Point>();
			 queue.add(new Point(assureY,assureX,land[assureY][assureX]==2?true : false));
			 visited[assureY][assureX]=true;
			 
			 int count=0;
//			 for(int u=0; u<land.length; u++) {
//				 for(int f=0; f<land[u].length; f++) {
//					 System.out.print(land[u][f] + " ");
//				 }
//				 System.out.println();
//			 }
			 
			 
			 while(!queue.isEmpty()) {
				 Point current=queue.poll();
				 int y=current.y;
				 int x=current.x;
				 boolean isCreate=current.isCreate;
				 
//				 if(visited[y][x]){
//					 continue;
//				 }
				 count++;
				 
				 if(isCreate==false) {
					 for(int k=0; k<4; k++) {
						 int newX=x+dxs[k];
						 int newY=y+dys[k];
						 if(newX < 0 || newX>=land[0].length || newY<0 || newY>=land.length) {
							 continue;
						 }
						 if(land[newY][newX]==1 && !visited[newY][newX]) {
							 visited[newY][newX]=true;
							 queue.add(new Point(newY, newX,false));
						 }else if(land[newY][newX]==2 && !visited[newY][newX]) {
							 visited[newY][newX]=true;
							 queue.add(new Point(newY, newX,true));
						 }
					 }
				 }else {
					 //위아래만 확인한다.
					 int moveTopAndBottom[]= {1,-1};
					 for(int k=0; k<2; k++) {
						 
						 int newY=y+moveTopAndBottom[k];
						 if(newY<0 || newY>=land.length) {
							 continue;
						 }
						 if(land[newY][x]==1 && !visited[newY][x]) {
							 visited[newY][x]=true;
							 queue.add(new Point(newY, x,false));
						 }else if(land[newY][x]==2 && !visited[newY][x]) {
							 visited[newY][x]=true;
							 queue.add(new Point(newY, x,true));
						 }
					 }
					 
					 
				 }
				 
				 
				 
			 }
			 count-=points.size();
			// System.out.println("count 에서 추가한 것 빼기 : "+count);
			 
			 if(max<count) {
				 max=count;
			 }
			 
			 //다시 돌아오기 1로 바꾼것은 0으로 바꾸기
			 //다시 모두 false로 바꾸기
			 for(Point p : points) {
				 land[p.y][p.x]=0;
			 }
			 points.clear();
			 for(int p=0; p<visited.length; p++) {
				 Arrays.fill(visited[p], false);
			 }
			 
			 
			 
			 
			 
		 }
		 
		 return max;
		 
		 
	 }
	 
	 class Point{
		 int y,x;
		 boolean isCreate; //true면 직접 만든거
		 public Point(int y,int x,boolean isCreate) {
			 this.isCreate=isCreate;
			 this.x=x;
			 this.y=y;
		 }
	 }

}
