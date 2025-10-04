package 입국심사_43238;

import java.util.Arrays;

public class Solution {

//	public static void main(String[] args) {
//	
//		Solution s=new Solution();
//		long n =s.solution(6, new int[] {7,10});
//	System.out.println(n);
//	}
	
	public long solution(int n , int times[]) {
		//t초안에 몇명 가능해?
		Arrays.sort(times);
		//long maxTime=(long)times[times.length-1]*n;
		long maxTime=(long)times[times.length-1]*n;
		
		//t가 작은값부터니까, 큰값부터 찾고 e를 축소
		long s=0;
		long e=maxTime+1;
		
		long mid=-1;
		while(s<e) {
			mid=(s+e)/2;
			if(processCount(n,times,mid)) {
				e=mid;
			}else {
				s=mid+1;
			}
		}
		
		System.out.println(s);
		return s;
		
		
	}
	
	public boolean processCount(int n, int times[], long time) {
		long sum=0;
		for(int i=0; i<times.length; i++) {
			sum+=time/times[i];
		}
		return n <= sum?true :false;
	}

}
