package 파괴되지않는건물;

import java.util.Arrays;

public class Solution {
	
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new int[][]{{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}}, new int[][]{{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}});
//	}
//	
	public int solution(int[][] board, int[][] skill) {
		
		int copy[][]=new int[board.length+1][board[0].length+1];
		
		//System.out.println(copy.length + " , "+ copy[0].length);
//		
//		 for(int i=0; i<copy.length; i++) {
//			 for(int j=0; j<copy[i].length; j++) {
//				 
//				 System.out.print(copy[i][j] + " , ");
//			 }
//			 System.out.println();
//			 System.out.println();
//		 }
		for(int i=0; i<skill.length; i++) {
			boardChange(copy,skill[i][0],skill[i][1],skill[i][2],skill[i][3],skill[i][4],skill[i][5]);
		}
		 int answer = 0;
		for(int i=0; i<copy.length; i++) {
			for(int j=0; j<copy[i].length; j++) {
				
				int left = j>0? copy[i][j-1] : 0;
				int top= i>0? copy[i-1][j] : 0;
				int diag= i>0 && j>0 ? copy[i-1][j-1] : 0;
				copy[i][j]+=left+top-diag;
				
					
			}
		}
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j]+copy[i][j] > 0 ) answer++;
			}
		}
		
       System.out.println(answer);
        return answer;
    }
	
	public void boardChange(int[][] board,int type , int x ,int y, int n, int m,int degree) {
		
		 if(type==1) {
			 degree=degree*-1;
		 }
		 //System.out.println(x+","+y +"    "+n+","+m);
		 board[x][y]+=degree;
		 board[x][m+1]-= degree;
		 board[n+1][y]-= degree;
		 board[n+1][m+1]+=degree;
		 
//		 
//		 for(int i=0; i<board.length; i++) {
//			 for(int j=0; j<board[i].length; j++) {
//				 System.out.print(board[i][j] + " , ");
//			 }
//			 System.out.println();
//			 System.out.println();
//		 }

	}

}
