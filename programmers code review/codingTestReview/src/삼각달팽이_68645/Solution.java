package 삼각달팽이_68645;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		int k[]=s.solution(1);
//		System.out.println(Arrays.toString(k));
//	}
//	
	public int[] solution(int n) {
		
		//boolean visited[][]=new boolean[n][n];
		int answer[][]=new int[n][n];
		int x=0;
		int y=0;
		int number=1;
		
		
		
		while(true) {
			if(y>=n||answer[y][x]!=0) {
				break;
			}
			
			//아래로이동
			answer[y][x]=number++;
			while(true) {
				y++;
				if(y>=n || answer[y][x]!=0) {
					y--;
					break;
				}
				answer[y][x]=number++;
			}
			
			//오른쪽으로 이동
			while(true) {
				x++;
				if(x>=n || answer[y][x]!=0) {
					x--;
					break;
				}
				answer[y][x]=number++;
			}
			
			//대각선으로 이동
			while(true) {
				y--;
				x--;
				if(x<0 || y<0 || answer[y][x]!=0) {
					x++;
					y++;
					break;
				}
				answer[y][x]=number++;
			}
			
			//printArr(answer);
			
			//출발지를 이동
			y++;
			
			
		}
		
		List<Integer> answerList=new ArrayList<Integer>();
		for(int i=0; i<answer.length; i++) {
			for(int j=0; j<answer[i].length; j++) {
				if(answer[i][j]==0) {
					break;
				}
				answerList.add(answer[i][j]);
			}
		}
		int m[]=answerList.stream()
					       .mapToInt((i)->i.intValue())
					       .toArray();
		
		
		
		return m;
		
	}
	
	public void printArr(int answer[][]) {
		for(int i=0; i<answer.length; i++) {
			for(int j=0; j<answer[i].length; j++) {
				System.out.printf("%2d ",answer[i][j]);
			}
			System.out.println();
		}
	}
	
	

}
