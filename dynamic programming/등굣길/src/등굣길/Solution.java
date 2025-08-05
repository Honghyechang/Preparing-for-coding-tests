package 등굣길;

public class Solution {
	
	private static int count=0;

	public static void main(String[] args) {

		Solution s=new Solution();
		int n=s.solution(4, 3, new int[][] {{2,2}});

		System.out.println(n);
	}

	public int solution(int m, int n, int[][] puddles) {
		int newPuddles[][]=coordinateToArray(puddles);
		recursion(m,n,newPuddles,0,0,0);
		return Solution.count;
    }
	
	public void recursion(int m, int n, int [][] puddles ,int x , int y , int depth) {
		
		//좌표 m=4 n=3 => [3][4]
		if(depth==(m-1)+(n-1)) {
			if(x==n-1 && y==m-1) {
				Solution.count++;
			}
			return;
		}
		
		
		if(existPuddles(puddles,x,y)) {
			return;
		}
		
		if(x>=n || y>=m) return;
		
		
		recursion(m,n,puddles,x+1,y,depth+1);

		recursion(m,n,puddles,x,y+1,depth+1);
		
	
	}
	
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
