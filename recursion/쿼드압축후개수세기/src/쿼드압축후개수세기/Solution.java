package 쿼드압축후개수세기;

public class Solution {

	public static void main(String[] args) {
		
		Solution s=new Solution();
		// TODO Auto-generated method stub
		int arr[][]= {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
		int result[]=s.solution(arr);
		System.out.println(result[0]+","+result[1]);
		
	}
	
	public int[] solution(int arr[][]) 
	{
		int result[]=new int[] {0,0};
		int sameNumber=sameNumberCheck(arr);
		
		//1번 모두가 다 같은지
		if(sameNumber==1) {
		result[1]+=1;
		return result;
		}
		else if(sameNumber==0) {
			result[0]+=1;
			return result;
		}
		else {
			int quarter[][][]=dividedQuarters(arr);
			return arraySum(solution(quarter[0]),solution(quarter[1]),solution(quarter[2]),solution(quarter[3]));
		}
		
	}
	

	
	//arr1에다가 arr2를 합치는 함수
	public int[] arraySum(int arr1[], int arr2[],int arr3[], int arr4[]) {
		return  new int[]{arr1[0]+arr2[0]+arr3[0]+arr4[0],arr1[1]+arr2[1]+arr3[1]+arr4[1]};
		 
	}
	//배열 절반으로 나누는 함수
	public int[][][] dividedQuarters(int arr[][]){
		int quarter[][][]=new int[4][arr.length/2][arr.length/2];
		int n=arr.length/2;
		
		//왼쪽위
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				quarter[0][i][j]=arr[i][j];
			}
		}
		//오른쪽위
		for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						quarter[1][i][j]=arr[i][j+n];
					}
				}
		//왼쪽아래
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				quarter[2][i][j]=arr[i+n][j];
			}
		}
		//오른쪽아래
		for(int i=0; i<n; i++) {
					for(int j=0; j<n; j++) {
						quarter[3][i][j]=arr[i+n][j+n];
					}
		}
		return quarter;
		
		
	}
	//같은 숫자인지 확인하는 함수
	public  int sameNumberCheck(int arr[][])
	{
		int sum=0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				sum+=arr[i][j];
			}
		}
		
		if(sum==arr.length*arr[0].length) {
			return 1;
		}
		else if(sum==0) {
			return 0;
		}else {
			return -1;
		}
	}

}
