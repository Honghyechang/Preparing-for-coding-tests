package day3;

import java.util.Arrays;

public class Solution1 {
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution1 s=new Solution1();
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
			answer[i]=cut(array,commands[i][0],commands[i][1],commands[i][2]);
		}
		return answer;
		
	}
	public int cut(int arr[],int start, int end, int k) {
		start=start-1;
		k=k-1;
		int cutArr[]=Arrays.copyOfRange(arr, start, end);
		Arrays.sort(cutArr);
	//	System.out.println(Arrays.toString(cutArr) + " ., " + cutArr[k]);
		return cutArr[k];
	}
}
