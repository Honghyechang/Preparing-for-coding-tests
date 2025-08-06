package 등굣길;
import java.util.Arrays;
public class Solution {
	
	private static int count=0;
	private static int memo[][]=new int[101][101];

//	public static void main(String[] args) {
//
//		Solution s=new Solution();
//		int n=s.solution(4, 3, new int[][] {{2,2}});
//
//		System.out.println(n);
//	}

	public int solution(int m, int n, int[][] puddles) {
		int newPuddles[][]=coordinateToArray(puddles);
		for(int i=0; i<memo.length; i++) {
			Arrays.fill(memo[i],-1);
		}
		
		return recursion(m,n,newPuddles,0,0,0);
    }
	
	public int recursion(int m, int n, int [][] puddles ,int x , int y , int depth) {
		
		//좌표 m=4 n=3 => [3][4]
		
		if(memo[x][y]!=-1)return memo[x][y];
		
		if(x==n-1 && y==m-1) {
			return 1;
		}
			
		
		
		if(existPuddles(puddles,x,y)) {
			return 0;
		}
		
		if(x>=n || y>=m) return 0;
		
		
		memo[x][y]=(recursion(m,n,puddles,x+1,y,depth+1)+recursion(m,n,puddles,x,y+1,depth+1) )%1000000007;
		return memo[x][y];

		
		
	
	}
//	
//public void recursion(int m, int n, int [][] puddles ,int x , int y , int depth) {
//		
//		//좌표 m=4 n=3 => [3][4]
//		if(depth==(m-1)+(n-1)) {
//			if(x==n-1 && y==m-1) {
//				Solution.count++;
//			}
//			return;
//		}
//		
//		
//		if(existPuddles(puddles,x,y)) {
//			return;
//		}
//		
//		if(x>=n || y>=m) return;
//		
//		
//		recursion(m,n,puddles,x+1,y,depth+1);
//
//		recursion(m,n,puddles,x,y+1,depth+1);
//		
//	
//	}
	
	public int[][] coordinateToArray(int [][]puddles){
		int newArray[][]=new int[puddles.length][];
		
		for(int i=0; i<puddles.length; i++) {
			int arr[]=puddles[i];
			int a=arr[1]-1;
			int b=arr[0]-1;
			int ab[]=new int[] {a,b};
			
			newArray[i]=ab;
		}
		return newArray;
	}
	//존재하면 true



public boolean existPuddles(int [][]puddles,int x ,int y) {
		for(int i=0; i<puddles.length; i++) {
			int arr[]=puddles[i];
			if(arr[0]==x && arr[1]==y) {
				return true;
			}
		}
		
		return false;
	}
}
