package 입국심사;

public class Solution {
//
//	public static void main(String[] args) {
//	
//		Solution s=new Solution();
//		int n =s.solution(6, new int[] {7,10});
//	System.out.println(n);
//	}
	
	public long solution(int n , int times[]) {
		long startTime=1;
		//초기 엔드타임은 가장 오래걸리는 사람한테 n만큼 받을떄
		long max=0;
		for(int m : times) {
			if(max < m) {
				max=m;
			}
		}
		
		long endTime=max*n;
		
		while(startTime<endTime) {
			
			long midTime=(startTime+endTime)/2;
			if(isValid(n,midTime,times)) {
				endTime=midTime;
				System.out.println("end업데이트 : "+endTime);
			}else {
				startTime=midTime+1;
				System.out.println("start업데이트 : "+startTime);
			}
			
		}
		
		return startTime;
	}
	
	public boolean isValid(int n, long t, int times[]) {
		long count=0;
		for(int k : times) {
			count+=t/k;
		}
		
		return count>=n;
	}

}
