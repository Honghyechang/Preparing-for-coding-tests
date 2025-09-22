package 행렬의곱셈_12949;

public class Solution {



//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution solution1=new Solution();
//		  // 올바른 배열 초기화 문법
//        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
//        int[][] arr2 = {{3, 3}, {3, 3}};
//        
//        int[][] result = solution1.solution(arr1, arr2);
//	}

	public int[][] solution(int arr1[][],int arr2[][]){
		
		int answer[][]=new int[arr1.length][arr2[0].length];
		//System.out.println(answer.length +","+answer[0].length);
		
		for(int i=0; i<answer.length; i++) {
			for(int j=0; j<answer[i].length; j++) {
				
				answer[i][j]=0;
				
				
				//m은 같다.
				//i , j 가 0일경우
				for(int m=0; m<arr2.length; m++) {
					answer[i][j]+=arr1[i][m]*arr2[m][j];
					
				}
				//System.out.print(answer[i][j]+" ");
				
				
			}
			//System.out.println();
		}
		
		
		
		return answer;
	}

	
}
