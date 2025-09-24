package 쿼드압축후개수세기_68936;

import java.util.Arrays;

public class Solution {
	
	int oneCount=0;
	int zeroCount=0;

//	public static void main(String[] args) {
//	
//	Solution s=new Solution();
//	// TODO Auto-generated method stub
//	int arr[][]= {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
//	int result[]=s.solution(arr);
//	System.out.println(result[0]+","+result[1]);
//	
//}

	
	public int[] solution(int arr[][]) {
		
		dfs(arr);
		int answer[]= {zeroCount,oneCount};
		System.out.println(Arrays.toString(answer));
		return answer;
	}
	
	public void dfs(int arr[][]) {
		
		//끝나는 조건은 
		//[1][1]일경우
		if(arr.length==1 && arr[0].length==1) {
			int n=arr[0][0];
			if(n==1) {
				oneCount++;
			}else if(n==0) {
				zeroCount++;
			}
			
			return;
		}
		
		
		int zero=0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j]==0) {
					zero++;
				}
			}
		}
		
		if(zero==0) {
			oneCount++;
		}else if(zero==arr.length * arr[0].length) {
			zeroCount++;
		}else {
			//4조각으로 나눠서 재귀함수
			int m=arr.length/2;
			
			
			//왼쪽 위
			int new_arr1[][]=new int[m][m];
			int new_arr2[][]=new int[m][m];
			int new_arr3[][]=new int[m][m];
			int new_arr4[][]=new int[m][m];
			for(int i=0; i<m; i++) {
				for(int j=0; j<m; j++) {
					new_arr1[i][j]=arr[i][j];
				}
			}
			//오른쪽 위
			for(int i=0; i<m; i++) {
				for(int j=m; j<m*2; j++) {
					new_arr2[i][j-m]=arr[i][j];
				}
			}
			
			//왼쪽 아래
			for(int i=m; i<m*2; i++) {
				for(int j=0; j<m; j++) {
					new_arr3[i-m][j]=arr[i][j];
				}
			}
			//오른쪽 아래
			for(int i=m; i<m*2; i++) {
				for(int j=m; j<m*2; j++) {
					new_arr4[i-m][j-m]=arr[i][j];
				}
			}
			
			dfs(new_arr1);
			dfs(new_arr2);
			dfs(new_arr3);
			dfs(new_arr4);
			
		}
		
		
		
		
		
		
		
	}
	
	
}
