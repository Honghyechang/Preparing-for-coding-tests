package 정수삼각형;

import java.util.Arrays;

public class Solution {

	public static int memory[][]=new int[501][501];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
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
		for(int i=0; i<memory.length; i++) {
			Arrays.fill(memory[i], -1);
		}
		int n=recurison(triangle, 0, 0);
		return n;
		
	}
	
	public int recurison(int triangle[][],int index,int depth) {
		
		if(memory[depth][index]!=-1)return memory[depth][index];
		if(depth==triangle.length) return 0;
		
		memory[depth][index]=triangle[depth][index]+Math.max(recurison(triangle,index,depth+1),recurison(triangle,index+1,depth+1));
		
		return memory[depth][index];
	}

}
