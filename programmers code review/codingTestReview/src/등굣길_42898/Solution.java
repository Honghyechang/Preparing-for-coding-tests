package 등굣길_42898;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Solution {
	
	int moveY,moveX;
	int answer=0;

//	public static void main(String[] args) {
//
//		Solution s=new Solution();
//		int n=s.solution(4, 3, new int[][] {{2,2}});
//
//		System.out.println(n);
//	}

	public int solution(int m, int n, int[][] puddles) {
		int memo[][]=new int[n][m];
		for(int i=0; i<memo.length; i++) {
			Arrays.fill(memo[i], -1);
		}
		//target n-1 , m-1이 될때까지
		//오른쪽, 아래만 이동이 가능하므로, 합이 m-1 + n-1 만큼
		//정확히는 오른쪽으로 m-1만큼 
		//아래쪽으로는 n-1만큼 이동을 해야한다.
		 moveY=n-1;
		 moveX=m-1;
		 
//		 List<Point> puddlesList=new ArrayList<Solution.Point>();
//		 for(int i=0; i< puddles.length; i++) {
//			 int y=puddles[i][1];
//			 int x=puddles[i][0];
//			 Point p=new Point(y, x);
//			 puddlesList.add(p);
//		 }
		 
		 int puddleMap[][]=new int[n][m];
		 for(int i=0; i< puddles.length; i++) {
		 int y=puddles[i][1]-1;
		 int x=puddles[i][0]-1;
		 puddleMap[y][x]=1;
	 }
		 
		 int an=dfs(puddleMap,0,0,memo);
		 System.out.println(an);
		 return an;
		 
		
		
	}
//	class Point{
//		int y,x;
//		public Point(int y,int x) {
//			this.y=y;
//			this.x=x;
//		}
//		
//		@Override
//		public boolean equals(Object obj) {
//			Point p=(Point)obj;
//			return this.y==p.y && this.x==p.x;
//		}
//		
//		@Override
//		public int hashCode() {
//			return Objects.hash(y,x);
//		}
//	}
	
	
	//해결법은 해당 출발지 -> 목적지 까지 경우의 수를 기록해두자! 라는것
	public int dfs( int puddleMap[][],int y,int x ,int memo[][]) {
		
	//	System.out.println(y+","+x+" 호출");
		//if(puddleMap[y][x]==1)return 0;
		if(memo[y][x]!=-1) {
			return memo[y][x];
		}
		
		if(y==moveY && x==moveX) {
			return 1;
		}
		
		int dxs[]= {0,1};
		int dys[]= {1,0};
		int count=0;
		//count 현재 위치부터 오른쪽, 아래로 가서 목적지 까지 갈 수 있는 경우의 수의 합
		for(int i=0; i<2; i++) {
			int newY=y+dys[i];
			int newX=x+dxs[i];
			if(newY>moveY || newX>moveX || puddleMap[newY][newX]==1) {
				continue;
			}
			count+=dfs(puddleMap,newY,newX,memo);
			count=count%1000000007;
		}
		
		memo[y][x]=count;
		return count;
	}
}
