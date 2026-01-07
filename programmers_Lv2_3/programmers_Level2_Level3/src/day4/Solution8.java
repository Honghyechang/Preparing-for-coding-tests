package day4;

import java.util.Arrays;

public class Solution8 {
	
	public static void main(String[] args) {
	Solution8 s=new Solution8();
	long n=s.solution(10000);
	System.out.println(n);

	}

	
	public long solution(int n) {

		//Arrays.fill(memo, -1);
		long memo[]=new long[100001];
		memo[0]=0;
		memo[1]=1;
		for(int i=2; i<=n; i++) {
			memo[i]=(memo[i-1]+memo[i-2])%1234567;
		}
		return memo[n];
		
	}
	
//	public long fibonachi(int n) {
//		//System.out.println(n);
//		if(n==0) {
//			System.out.println("f(0)");
//			return 0;
//		}
//		if(n==1) {
//
//			System.out.println("f(1)");
//			return 1;
//		}
//		
//		if(memo[n]!=-1) {
//			return memo[n];
//		}
//		
//		long m=(fibonachi(n-1)+fibonachi(n-2))%1234567;
//		memo[n]=m;
//		return m;
//		
//		
//	}
	

}
