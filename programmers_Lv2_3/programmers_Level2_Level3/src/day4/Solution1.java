package day4;

import java.util.Arrays;

public class Solution1 {

	
//	public static void main(String[] args) {
//	
//		Solution1 s=new Solution1();
//		long n =s.solution(6, new int[] {7,10});
//	System.out.println(n);
//	}
//	
	public long solution(int n , int times[]) {

		Arrays.sort(times);
		long start=1;
		long end=((long)times[times.length-1]*n )+1;
		//가능한것중에 최솟값을 찾는것
		while(start<end) {
			long mid=(start+end)/2;
			if(isPossible(mid,times,n)) {
				end=mid;
			}else {
				start=mid+1;
			}
		}
		System.out.println(start);
		return start;
		
		
	}
	
	public boolean isPossible(long t,int times[],int n) {
		long sum=0;
		for(int time : times) {
			sum += t/time;
		}
		return sum>=n? true : false;
		
	}
	
}
