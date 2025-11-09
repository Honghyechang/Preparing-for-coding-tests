package 지게차와크래인_388353;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution(new String[] {"AZWQY", "CAABX", "BBDDA", "ACACA"}, new String[] {"A", "BB", "A"});
//}
 public int solution(String[] storage, String[] requests) {

	 //1)방문했으면 다 true로 바꾸기
	 //2)가장 자리 연장시키기 1이면서 방문했다면 연장시키기

	 char map[][]=new char[storage.length][storage[0].length()];
	 for(int i=0; i<storage.length; i++) {
		 map[i]=storage[i].toCharArray();
	 }
	 
//	 for(int i=0; i<map.length; i++) {
//		 for(int j=0; j<map[i].length; j++) {
//			 System.out.print(map[i][j] + " ");
//		 }
//		 System.out.println();
//	 }
	 
	 
	 int n=getAnswer(map,requests);
	 System.out.println(n);
	 return n;
	 
 }
 
 public int getAnswer(char map[][] , String request[]) {
	 
	 //방문했는지
	 boolean visited[][]=new boolean[map.length][map[0].length];
	 //가장자리=이동가능한지
	 boolean available[][]=new boolean[map.length][map[0].length];
	 //available초기화
	 for(int i=0; i<available.length; i++) {
		 for(int j=0; j<available[i].length; j++) {
			 if(i==0 || j==0 || i==available.length-1 || j==available[i].length-1) {
				 available[i][j]=true;
			 }
		 }
	 }
	 
	 //print(available);
	 for(String rq : request) {
		 if(rq.length()==1) {
			 //가장자리만
			 visitedUpdateOnlyAvailable(visited, available,map,rq.charAt(0));
		 }else {
			 //모두
			 visitedUpdateAll(visited,map,rq.charAt(0));
		 }
		 
		 //visited를 토대로 가장자리 업데이트하기
		 availableUpdate(visited,available);
		// print(available);
		// System.out.println();

		 //System.out.println();

	 }
	 
	 
	 
	 int answer=0;
	 //System.out.println("방문결과");
	 for(int i=0; i<visited.length; i++) {
		 for(int j=0; j<visited[i].length; j++) {
			//System.out.print(visited[i][j] + " ");
			 if(!visited[i][j]) {
				 answer++;
			 }
		 }
		 //System.out.println();
	 }
	 
	 
	 return answer;
	 
	 
 }
 
 public void availableUpdate(boolean visited[][], boolean available[][]) {
	 
	 //둘다 true인것을 queue에다 우선 넣기
	 //int[] = {y , x} 좌표
	 Queue<int[]> queue=new LinkedList<int[]>();
	 
	 boolean availableVisited[][]=new boolean[visited.length][visited[0].length];
	 
	 for(int i=0; i<available.length; i++) {
		 for(int j=0; j<available[i].length; j++) {
			if(available[i][j]==true && visited[i][j]==true) {
				queue.add(new int[] {i,j});
				availableVisited[i][j]=true;
			}
		 }
	 }
	 int dys[]= {0,0,-1,1};
	 int dxs[]= {1,-1,0,0};
	 while(!queue.isEmpty()) {
		 int position[]=queue.poll();
		 int y=position[0];
		 int x=position[1];
		// System.out.println(y+","+x);
		 
		 for(int i=0; i<4; i++) {
			 int moveY=y+dys[i];
			 int moveX=x+dxs[i];
			 
			 if(moveY < 0 || moveX < 0 || moveY >= visited.length || moveX >= visited[0].length) continue;
			 //System.out.println(moveY +" , "+moveX);
			 available[moveY][moveX]=true;
			 
			 if(visited[moveY][moveX] && availableVisited[moveY][moveX]==false) {
				 availableVisited[moveY][moveX]=true;
				 queue.add(new int[] {moveY,moveX});
			 }
			 
			 
		 }
		  
	 }
	 
	 
	 
 }
 
 
 public void visitedUpdateOnlyAvailable(boolean visited[][], boolean available[][] ,char map[][] , char ch) {
	 
	 
	 for(int i=0; i<available.length; i++) {
		 for(int j=0; j<available[i].length; j++) {
			if(available[i][j]==true && map[i][j]==ch) {
				visited[i][j]=true;
			}
		 }
	 }
	 
	 
 }
 
 public void visitedUpdateAll(boolean visited[][],char map[][] , char ch) {
	 for(int i=0; i<map.length; i++) {
		 for(int j=0; j<map[i].length; j++) {
			if(map[i][j]==ch) {
				visited[i][j]=true;
			}
		 }
	 }
	 
	 
 }
 
 public void print(boolean map[][]) {
	 for(int i=0; i<map.length; i++) {
		 for(int j=0; j<map[i].length; j++) {
			 System.out.print(map[i][j] + " ");
		 }
		 System.out.println();
	 }
 }
}
