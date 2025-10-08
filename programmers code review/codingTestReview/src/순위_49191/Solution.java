package 순위_49191;

public class Solution {
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	
//	Solution s=new Solution();
//	int n=s.solution(5, new int[][] {
//		{4,3},{4,2},{3,2},{1,2},{2,5}
//	});
//	System.out.println(n);
//
//}

 public int solution(int n, int[][] results) {
	 
	 boolean map[][]=new boolean[n+1][n+1];
	 
	 
	 //건너 건너 이긴다 + 건너 건너 진다 = n-1개면 알 수 있다.
	 for(int result[] : results) {
		 int win=result[0];
		 int lose=result[1];
		 map[win][lose]=true;
	 }
	 int answer=0;
	 
	 for(int i=1; i<=n; i++) {
		 //i가 이기는 회수
		 int winCount=getWinCount(i,map,new boolean[n+1]);
		 //i가 지는 회수
		 int loseCount=getLoseCount(i,map,new boolean[n+1]);
		 
		 if(winCount + loseCount==n-1) {
			 answer++;
		 }
	 }
	 System.out.println(answer);
	 
	 return answer;
	
	 
 }
 
 public int getWinCount(int winIndex,boolean map[][],boolean winVisited[]) {
	 //win 이긴다 라면,
	 winVisited[winIndex]=true;
	 int count=0;
	 for(int i=0; i<map.length; i++) {
		if(winVisited[i]==true) continue;
		 
		if (map[winIndex][i]==true) {
			//i를 이긴다
			//=> i가 n 을 이기면  winIndex > i > i보다 지는애 n..
			count=count+1+getWinCount(i,map,winVisited);
		}
	 }
	 return count;
 }
 
 public int getLoseCount(int loseIndex,boolean map[][],boolean loseVisited[]) {
	 //win 이긴다 라면,
	 loseVisited[loseIndex]=true;
	 int count=0;
	 for(int i=0; i<map.length; i++) {
		if(loseVisited[i]==true) continue;
		 
		if (map[i][loseIndex]==true) {
			//i를 이긴다
			//=> i가 n 을 이기면  winIndex > i > i보다 지는애 n..
			count=count+1+getLoseCount(i,map,loseVisited);
		}
	 }
	 return count;
 }

}
