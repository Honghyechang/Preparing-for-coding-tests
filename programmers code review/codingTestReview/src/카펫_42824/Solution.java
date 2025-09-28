package 카펫_42824;

import java.util.ArrayList;
import java.util.List;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		s.solution(24, 24);
//
//	}
	public int[] solution(int brown, int yellow) 
	{
		
		List<Point> pointList=new ArrayList<Solution.Point>();
		
		System.out.println(Math.sqrt(yellow));
		for(int i=1; i<=Math.sqrt(yellow); i++) {
			
			if(yellow%i==0) {
				int m=yellow/i;
				Point p=new Point(m,i);
				pointList.add(p);
			}
		}
		
		for(Point p : pointList) {
			int row=p.row; //가로
			int col=p.col;//세로
			
			int createBox=(2*col) + ((row+2)*2);
			
			//System.out.println(row + " ,"+col +" -> "+createBox);
			if(createBox==brown) {
				
				//System.out.println("row : "+(row+2) +" , col : "+(col+2));
				return new int[] {row+2,col+2};
			}
			
			
		}
		
		
		return new int[2];
	}
	
	class Point{
		int row;//가로 크기
		int col;//세로 크기     가로 > 세로
		public Point(int row,int col) {
			
			this.row=row;
			this.col=col;
		}
 	}
}
