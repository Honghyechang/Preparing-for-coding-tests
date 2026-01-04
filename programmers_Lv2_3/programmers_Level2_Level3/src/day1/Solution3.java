package day1;

public class Solution3 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Solution3 solution1=new Solution3();
	  // 올바른 배열 초기화 문법
    int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
    int[][] arr2 = {{3, 3}, {3, 3}};
    
    int[][] result = solution1.solution(arr1, arr2);
}

public int[][] solution(int arr1[][],int arr2[][]){
	
	//결국 구하고자 하느것
	int answer[][]=new int[arr1.length][arr2[0].length];
	
	for(int i=0; i<answer.length; i++) {
		for(int j=0; j<answer[i].length; j++) {
			
			for(int m=0; m<arr1[0].length; m++) {
				answer[i][j]+=arr1[i][m]*arr2[m][j];
			}
			
			//System.out.println(answer[i][j]+" ");
			
		}
		
	}
	return answer;
}


}
