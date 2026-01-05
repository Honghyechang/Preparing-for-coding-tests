package day2;

import java.util.Arrays;

public class Solution1 {

	public static void main(String[] args) {
	
	Solution1 s=new Solution1();
	// TODO Auto-generated method stub
	int arr[][]= {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
	int result[]=s.solution(arr);
	System.out.println(result[0]+","+result[1]);
	
}

	int oneCount=0;
	int zeroCount=0;
	
	public int[] solution(int arr[][]) {
		
		packageCount(arr);
		int answer[]=new int[] {zeroCount,oneCount};
	//	System.out.println(Arrays.toString(answer));
		return answer;
		
	}
	
	public void packageCount(int arr[][]) {
		//1 또는 0라면 카운트 증가 후 리턴
		boolean check=zeroOrOneCheck(arr);
		//아니라면 4등분으로 쪼개기
		if(!check) {
			//4등분
			int m=arr.length/2;
			int divarr[][]=new int[m][m];
			
			for(int i=0; i<m; i++) {
				for(int j=0; j<m; j++) {
				divarr[i][j]=arr[i][j];
				}
			}
			packageCount(divarr);
			
			for(int i=m; i<2*m; i++) {
				for(int j=0; j<m; j++) {
				divarr[i-m][j]=arr[i][j];
				}
			}
			packageCount(divarr);
			
			
			for(int i=0; i<m; i++) {
				for(int j=m; j<2*m; j++) {
				divarr[i][j-m]=arr[i][j];
				}
			}
			packageCount(divarr);
			
			for(int i=m; i<2*m; i++) {
				for(int j=m; j<2*m; j++) {
				divarr[i-m][j-m]=arr[i][j];
				}
			}
			packageCount(divarr);
		}
		
	}
	
	public boolean zeroOrOneCheck(int arr[][]) {
		int zero=0;
		int target=arr.length*arr[0].length;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j]==0) {
					zero++;
				}
			}
		}
		if(zero==target) {
			zeroCount++;
			return true;
		}
		else if(zero==0) {
			oneCount++;
			return true;
		}else {
			return false;
		}
		
	}
	
	
}
