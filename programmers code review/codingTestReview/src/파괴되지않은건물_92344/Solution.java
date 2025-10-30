package 파괴되지않은건물_92344;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//	Solution s=new Solution();
//	s.solution(new int[][]{{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}}, new int[][]{{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}});
//}
//
public int solution(int[][] board, int[][] skill) {
	
	int s[][]=new int[board.length+1][board[0].length+1];
	for(int i=0; i<skill.length; i++) {
		int degree=skill[i][5];
		if(skill[i][0]==1) {
			degree=degree*-1;
		}
		int startY=skill[i][1];
		int startX=skill[i][2];
		int endY=skill[i][3];
		int endX=skill[i][4];
		
		s[startY][startX]+=degree;
		s[endY+1][startX]-=degree;
		s[startY][endX+1]-=degree;
		s[endY+1][endX+1]+=degree;
	}
	
	int answer=0;
	for(int i=0; i<s.length; i++) {
		for(int j=0; j<s[i].length; j++) {
			
			int top=i==0? 0:s[i-1][j];
			int left= j==0? 0 : s[i][j-1];
			int dig= i==0 || j==0 ? 0 : s[i-1][j-1];
			s[i][j]=s[i][j] + (top + left)-dig;
		}
	}
	
	for(int i=0; i<board.length; i++) {
		for(int j=0; j<board[i].length; j++) {
			
			board[i][j]=board[i][j]+s[i][j];
			if(board[i][j]>0) {
				answer++;
			}
			
		}
	}
	System.out.println(answer);
	return answer;
}
}
