package 정수삼각형_43105;

import java.util.Arrays;

public class Solution {
	
	int map[][]=new int[501][501];
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
//	int n=s.solution(new int[][] {
//		{7}, 
//		{3, 8}, 
//		{8, 1, 0}, 
//		{2, 7, 4, 4}, 
//		{4, 5, 2, 6, 5}
//		}
//	);
//	System.out.println(n);
//
//}

	public int solution(int triangle[][]) {
		
		for(int i=0; i<map.length; i++) {
			Arrays.fill(map[i], -1);
		}
		
		int max=selectMax(triangle,0,0);
		return max;
	}
	
	public int selectMax(int triangle[][],int x, int y) {
		
		if(y==triangle.length-1) {
			map[y][x]= triangle[y][x];
			return triangle[y][x];
		}
		if(map[y][x]!=-1)return map[y][x];
		
		//왼쪽 최대  or 오른쪽 최대중 하나를 고른다.
		int max=triangle[y][x]+Math.max(  selectMax(triangle,x,y+1) ,selectMax(triangle,x+1,y+1) );
		map[y][x]=max;
		return  max;
	}
	
	
	
}
