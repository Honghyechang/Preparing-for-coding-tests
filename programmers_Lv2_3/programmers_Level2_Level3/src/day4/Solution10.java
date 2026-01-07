package day4;

import java.util.Arrays;

public class Solution10 {
	public static void main(String[] args) {

		Solution10 s=new Solution10();
		int n=s.solution(4, 3, new int[][] {{2,2}});

		System.out.println(n);
	}

	int y;
	int x;
	public int solution(int m, int n, int[][] puddles) {

		y=n;
		x=m;
		boolean map[][]=new boolean[n][m];
		for(int i=0; i<map.length; i++) {
			Arrays.fill(map[i], true);
		}
		
		for(int p[] : puddles) {
			map[p[1]-1][p[0]-1]=false;  
		}
		
		for(int k[] : memo) {
			Arrays.fill(k, -1);
		}
		
		
		return getRoute(map,0,0);
		
	}
	
	int memo[][]=new int[101][101];
	public int getRoute(boolean map[][],int y, int x) {
		if(y>=map.length || x>=map[0].length || !map[y][x]) {
			return 0;
		}
		
		if(y==map.length-1 && x==map[0].length-1) {
			return 1;
		}
		
		if(memo[y][x]!=-1) {
			return memo[y][x];
		}
		
		//오른쪽 , 아래쪽
		memo[y][x]= ( getRoute(map,y+1,x) +getRoute(map,y,x+1) ) %1000000007;
		return memo[y][x];
		
		
	}
	
	
}
