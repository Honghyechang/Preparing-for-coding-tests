package 지게차와크래인_388353;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution(new String[] {"AZWQY", "CAABX", "BBDDA", "ACACA"}, new String[] {"A", "BB", "A"});
//	}
	 public int solution(String[] storage, String[] requests) {
		 //["AZWQY", "CAABX", "BBDDA", "ACACA"]
		 int y=storage.length;
		 int x=storage[0].length();
		 
		 char [][]map=new char[y][x];
		 for(int i=0; i<storage.length; i++) {
			 String str=storage[i];
			 char chars[]=new char[x];
			 for(int j=0; j<str.length(); j++) {
				 char ch=str.charAt(j);
				 chars[j]=ch;
			 }
			 map[i]=chars;
		 }
		 
		 return hyechangSolution(map,requests);
		 
		 
		 

	 }
	 
	 public int hyechangSolution(char[][] map, String[] requests) {
		 
		 //접근 가능한 것을 1! 접근 불가능한 것은 0
		 //방문한 것은 true ,방문하지 않은것은 false;
		 int aceesible[][]=new int[map.length][map[0].length];
		 boolean visited[][]=new boolean[map.length][map[0].length];
		 
		 //처음 초기화는 가장자리 애들만 1로 바꾸기
		 for(int i=0; i<aceesible.length; i++) {
			 for(int j=0;j<aceesible[i].length; j++) {
				 if(i==0 || j==0 || i==aceesible.length-1 || j==aceesible[i].length-1) {
					 aceesible[i][j]=1;
				 }
			 }
		 }
		 
		 for(int i=0; i<map.length; i++) {
			
			 for(int j=0; j<map[0].length; j++) {
				//System.out.print(map[i][j]+ " ");
			 }
			// System.out.println();
		 }
		 
		 
		 //System.out.println("====초기화 ====");
		 //printAceesibleArr(aceesible);
		 
		 
		 
		 for(String request :requests) {
			 char removeChar=request.charAt(0);
			// System.out.println(request +" 처리 시작 removeChar : "+removeChar);
			 if(request.length()==1) {
				 //1이라면 접근 가능한것만
				 
				 //방문한 것으로 바꾸기
				 for(int i=0; i<aceesible.length; i++) {
					 for(int j=0;j<aceesible[i].length; j++) {
						 if(aceesible[i][j]==1 && map[i][j]==removeChar) {
							 visited[i][j]=true;
						 }
					 }
				 }
				// System.out.println("방문 업데이트");
				 //printVisitedArr(visited);
				 
				 
				 //방문한 것을 토대로 업데이트 시키기
				 aceesibleUpdate(aceesible,visited);
				 
				// System.out.println("접근 가능 업데이트");
				 //printAceesibleArr(aceesible);
				 
				
			 }else if(request.length()==2) {
				 //2라면 모든 것을 다 지우기
				 for(int i=0; i<aceesible.length; i++) {
					 for(int j=0;j<aceesible[i].length; j++) {
						 if(map[i][j]==removeChar) {
							 visited[i][j]=true;
						 }
					 }
				 }
				 
				 //주의할점은 가운데에 것을 없애도 그자리의 aceesible은 그냥 그대로 0을 두었다.
				 
				 //System.out.println("방문 업데이트");
				 //printVisitedArr(visited);
				 
				 
				 //없앴는데, 그 없앤 부분이 1이 아니었을경우에는
				 //그 자리에 위아래오왼이 하나라도 1이었다면 그 주변을 1로 바꾸기!
				 
 				 
				 
				 //방문한 것을 토대로 업데이트 시키기
				 aceesibleUpdate(aceesible,visited);
				 
				 //System.out.println("접근 가능 업데이트");
				 //printAceesibleArr(aceesible);
				
			 }
		 }
		 
		 int falseCount=0;
		 for(int i=0; i<visited.length; i++) {
			 for(int j=0;j<visited[i].length; j++) {
				if(!visited[i][j]) {
					falseCount++;
			 }
			 
		 }
		
		 
	    }
		 System.out.println("answer : "+falseCount);
		 
		 return falseCount;
	 }
	 class Point{
		 int x,y;
		 public Point(int y,int x) {
			 this.x=x;
			 this.y=y;
		 }
	 }
	 
	 public void aceesibleUpdate( int aceesible[][], boolean visited[][] ) {
		 //queue를 이용해서 1이면서 true면 업데이트 시키기
		 Queue<Point> queue=new LinkedList<Solution.Point>();
		 for(int i=0; i<aceesible.length; i++) {
			 for(int j=0;j<aceesible[i].length; j++) {
				 if(aceesible[i][j]==1 && visited[i][j]==true) {
					 Point p=new Point(i, j);
					 queue.add(p);
				 }
			 }
	    }
	 //위 , 아래, 왼쪽 ,오른쪽이 true라면 1로 방문가능으로 업데이트시키기
		 
		 int dxs[]= {0,0,1,-1};
		 int dys[]= {1,-1,0,0};
		 
		 while(!queue.isEmpty()) {
			 Point pollPoint=queue.poll();
			 int pollY=pollPoint.y;
			 int pollX=pollPoint.x;
			 
			 for(int i=0; i<4; i++) {
				 int newY=pollY+dys[i];
				 int newX=pollX+dxs[i];
				 
				 if(newY<0 || newY >=aceesible.length || newX <0 || newX >=aceesible[0].length) {
					 continue;
				 }
				 if(aceesible[newY][newX]!=1) {
					 aceesible[newY][newX]=1;
					 if(visited[newY][newX]) {
						 queue.add(new Point(newY, newX));
					 }
				 }
			 }
			 
			 
		 }
		 
		 
		 
	
	 }
	 
	
	 public  void  printAceesibleArr(int arr[][]) {
		 for(int i=0; i<arr.length; i++) {
			 for(int j=0;j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			 }
			 System.out.println();
		 }
		 System.out.println();
		 
	 }
	 
	 public  void  printVisitedArr(boolean arr[][]) {
		 for(int i=0; i<arr.length; i++) {
			 for(int j=0;j<arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			 }
			 System.out.println();
		 }
		 System.out.println();
		 
	 }

}
