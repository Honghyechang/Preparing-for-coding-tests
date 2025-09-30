package 석유시츄_250136;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}});
//		
//	}
//	
	 public int solution(int[][] land) {
	        int answer = bfs(land);
	        System.out.println(answer);
	        
	        return answer;
	  }
	 
	 public int bfs(int[][] land) {
		 
		 
		 Map<Integer,Integer> maps=new HashMap<Integer, Integer>();
		 boolean visited[][]=new boolean[land.length][land[0].length];
		 int max=Integer.MIN_VALUE;

		 //그룹별로 숫자를 업데이트시키기
		 // 22222 ,3333 ,4444
		 int plus=1;
		 int dys[]= {0,0,1,-1};
		 int dxs[]= {1,-1,0,0};
		 for(int i=0; i<land.length; i++) {
		 for(int j=0; j<land[i].length; j++) {
			if(land[i][j]==1) {
				//그부분은 모두 1+plus로 업데이트를시킨다.
				 //무조건 assureX,assureY를 지나가니까 이것을 시작으로 둔다.
				 Queue<Solution.Point> queue=new LinkedList<Solution.Point>();
				 queue.add(new Point(i,j));
				 visited[i][j]=true;
				 int key=land[i][j]+plus;
				 land[i][j]+=plus;
				
				 int count=0;
				 while(!queue.isEmpty()) {
					 Point current=queue.poll();
					 int y=current.y;
					 int x=current.x;
					 
//					 if(visited[y][x]){
//						 continue;
//					 }
					 count++;
					 for(int k=0; k<4; k++) {
						 int newX=x+dxs[k];
						 int newY=y+dys[k];
						 if(newX < 0 || newX>=land[0].length || newY<0 || newY>=land.length) {
							 continue;
						 }
						 if(land[newY][newX]==1 && !visited[newY][newX]) {
							 land[newY][newX]+=plus;
							 visited[newY][newX]=true;
							 queue.add(new Point(newY, newX));
						 }
					 }
						 
						 
					 }
				 
				 
				     maps.put(key, count);
				     plus++;
				
			}
			
		 }
		 
	 }
//		 System.out.println("map 상황");
//		 for(int a : maps.keySet()) {
//			 System.out.println(a +" : "+maps.get(a));
//		 }
		 
//		 for(int i=0; i<land.length; i++) {
//			 for(int j=0; j<land[i].length; j++) {
//				 System.out.print(land[i][j]+" ");
//			 }
//			 System.out.println();
//		 }
		 
		 
		 
		 Set<Integer> colwContainSet=new HashSet<Integer>();
		 
		 for(int i=0; i<land[0].length; i++) {
		 for(int j=0; j<land.length; j++) {
			 //j가 y i 가 x
			 if(land[j][i]!=0) {
				 colwContainSet.add(land[j][i]);
			 }
			
			// System.out.print(land[i][j]+" ");
		 }
		 
		 int sum=0;
		 for(Integer key : colwContainSet) {
			sum+= maps.get(key);
		 }
		 if(max<sum) {
			 max=sum;
		 }
		 
		 colwContainSet.clear();
		// System.out.println();
	 }
		
		// System.out.println(max);
		 
		
		 
		 return max;
		 
		 
	 }
	 
	 class Point{
		 int y,x;
		 public Point(int y,int x) {
			
			 this.x=x;
			 this.y=y;
		 }
	 }

}
