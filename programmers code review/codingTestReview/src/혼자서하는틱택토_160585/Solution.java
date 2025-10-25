package 혼자서하는틱택토_160585;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//Solution s=new Solution();
//int result=s.solution(new String[] {"O.X", ".O.", "..X"});
//System.out.println(result);
//	}

	public int solution(String[] board) {
		//가능하면 1 불가능하면 0
		
		
		
		char gameboard[][]=new char[3][3];
		
		String boardString="";
		for(String b : board) {
			boardString+=b;
		}
		
		
		int ocount=0;
		int xcount=0;
		
		for(int i=0; i<boardString.length(); i++)
		{
			int y=i/3;
			int x=i%3;
			gameboard[y][x]=boardString.charAt(i);
			
			if(gameboard[y][x]=='O') {
				ocount++;
			}else if(gameboard[y][x]=='X') {
				xcount++;
			}
			
		}
		
		
		
		//O	부터시작하니까 X가 더많아질 순없다
				//O , X 개수가 같은 상황에서 게임이 끝날 순 없다.
				//O과 X의 차이는 0개 또는 1개일것이다.
				//X만 1개일순없다.
				
				// X개수 > Y개수    실패
				// X개수 = Y개수    X개수가 끝낼순있어도 , Y개수는 완성되지 않아야한다.
				// Y개수 > X개수    X개수보다 1개 더 많아야한다. , 동시에 x빙고가 완성되지 않은 상태여야한다.
		
		
		if(xcount>ocount) {
			return 0;
		}else if(xcount<ocount) {
			
			if(ocount!=xcount+1) {
				return 0;
			}
			
			if(isXbingo(gameboard)) {
				return 0;
			}
			
		}else {
			if(isObingo(gameboard)) {
				return 0;
			}
		}
		
		return 1;
		
	}
	
	public boolean isObingo(char [][] gameboard) {
		//0 1 2
		//3 4 5
		//6 7 8
		//일때
		
		int bingoArr[][]= {
				{0,1,2},{3,4,5},{6,7,8},
				{0,3,6},{1,4,7},{2,5,8},
				{0,4,8},{2,4,6}
		};
		
		for(int arr[] : bingoArr) {
			
			int y1=arr[0]/3;
			int x1=arr[0]%3;
			

			int y2=arr[1]/3;
			int x2=arr[1]%3;
			

			int y3=arr[2]/3;
			int x3=arr[2]%3;
			
			if(gameboard[y1][x1]=='O' && gameboard[y2][x2]=='O' && gameboard[y3][x3]=='O') {
				return true;
			}
			
			
			
		}
		return false;
		
	}
	
	public boolean isXbingo(char [][] gameboard) {
		//0 1 2
		//3 4 5
		//6 7 8
		//일때
		
		int bingoArr[][]= {
				{0,1,2},{3,4,5},{6,7,8},
				{0,3,6},{1,4,7},{2,5,8},
				{0,4,8},{2,4,6}
		};
		
		for(int arr[] : bingoArr) {
			
			int y1=arr[0]/3;
			int x1=arr[0]%3;
			

			int y2=arr[1]/3;
			int x2=arr[1]%3;
			

			int y3=arr[2]/3;
			int x3=arr[2]%3;
			
			if(gameboard[y1][x1]=='X' && gameboard[y2][x2]=='X' && gameboard[y3][x3]=='X') {
				return true;
			}
			
			
			
		}
		return false;
		
	}
	
	
}
