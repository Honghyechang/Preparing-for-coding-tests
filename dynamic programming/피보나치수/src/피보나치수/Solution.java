package 피보나치수;

import java.util.Arrays;

public class Solution {
	
	public static long memory[]=new long[100001];

//	public static void main(String[] args) {
//		Solution s=new Solution();
//		long n=s.solution(5);
//		System.out.println(n);
//
//	}

	public long solution(int n) {
		Arrays.fill(memory,-1);
		
		return fibonacci(n);
		
		
	}
	
	public long fibonacci(int n) {
		if(memory[n]!=-1)return memory[n];
		if(n==1||n==0)return n;
		return memory[n]=(fibonacci(n-1)+fibonacci(n-2))%1234567;
	}
}
