package 피보나치수열_12945;

public class Solution {

//	public static void main(String[] args) {
//	Solution s=new Solution();
//	long n=s.solution(100000);
//	System.out.println(n);
//
//	}

	public long solution(int n) {
		long map[]=new long[100001];
		map[0]=0;
		map[1]=1;
		for(int i=2; i<map.length; i++) {
			map[i]=(map[i-1]+map[i-2])%1234567;
		//	System.out.println(map[i]);
		}
		
		long get=map[n];
		return get;
	}
}
