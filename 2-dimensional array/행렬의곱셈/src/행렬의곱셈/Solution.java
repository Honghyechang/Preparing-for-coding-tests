package 행렬의곱셈;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution1=new Solution();
		  // 올바른 배열 초기화 문법
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        
        int[][] result = solution1.solution(arr1, arr2);
	}

	public int[][] solution(int arr1[][],int arr2[][]){
		
		int m=arr1.length;
		int n=arr2[0].length;
		
		int z=arr1[0].length;
		
		
		int result[][]=new int[m][n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				
				result[i][j]=0;
				for(int k=0; k<z; k++) {
					result[i][j]+=arr1[i][k]*arr2[k][j];
				}
				
				System.out.print(result[i][j]+"  ");
			}
		}
		
		return result;
	}
}
