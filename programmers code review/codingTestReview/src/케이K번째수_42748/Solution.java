package 케이K번째수_42748;

import java.util.Arrays;

public class Solution {
//
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
//	int a[]= {1,5,2,6,3,7,4};
//	int b[][]= {
//			{2,5,3},{4,4,1},{1,7,3}
//	};
//	int n[]=s.solution(a,b);
//	System.out.println(Arrays.toString(n));
//
//}
	public int[] solution(int array[],int commands[][]) {
		
		int answer[]=new int[commands.length];
		for(int i=0; i<commands.length; i++) {
			int start=commands[i][0];
			int end=commands[i][1];
			int k=commands[i][2];
			
			int arr[]=Arrays.copyOfRange(array, start-1, end);
			Arrays.sort(arr);
			
			answer[i]=arr[k-1];
			
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
