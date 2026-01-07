package day4;

import java.util.Arrays;

public class Solution9 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Solution9 s=new Solution9();
	int n=s.solution(new int[][] {
		{7}, 
		{3, 8}, 
		{8, 1, 0}, 
		{2, 7, 4, 4}, 
		{4, 5, 2, 6, 5}
		}
	);
	System.out.println(n);

}

	public int solution(int triangle[][]) {

		for(int i=0; i<memo.length; i++) {
			Arrays.fill(memo[i], -1);
		}
		
		int n=getTriangle(0,triangle,0);
		System.out.println(n);
		
		return n;
		
	}
	int memo[][]=new int[500][500];	
	//내 레벨단계과 현재 인덱스
	public int getTriangle(int level, int triangle[][] , int index) 
	{
		if(memo[level][index]!=-1) {
			return memo[level][index];
		}
		
		if(level==triangle.length-1) {
			return triangle[level][index];
		}
		int max=triangle[level][index] + Math.max( getTriangle(level+1,triangle,index) ,  getTriangle(level+1,triangle,index+1));
		memo[level][index]=max;
		return max;
		
	}
}
