package 연속된부분수열의합_178870;

import java.util.Arrays;

public class Solution {
	
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new int[] {2, 2, 2, 2, 2}, 6);
//	}
	
	 public int[] solution(int[] sequence, int k) {
		// System.out.println(Arrays.toString(sequence));
		 //2포인터문제
		 boolean isfind=false;
		 int start=-1;
		 int end=-1;
		 
		 int s=0;
		 int e=0;
		 int sum=sequence[s];
		 
		 //조건에 만족할동안 e++
		 //만족하면 그때의 그 s , e 기록(가장 짧을 시 업데이트)
		 //s++늘리기
		 
		 while(s<sequence.length) {
			 
			 if(sum==k) {
				 //s이동
				 if(!isfind) {
					 start=s;
					 end=e;
					 //로 첫 업데이트
					 isfind=true;

				 }else {
					 if(end-start > e-s) {
						 //더 작아야 찾는다.
						 end=e;
						 start=s;

					 }
				 }
				 
				 //현재 s값을 뺀다
				 sum-=sequence[s];
				 s++;				 
				 
			 }else if(sum<k){
				 //e이동
				 if(e==sequence.length-1) {
					 break;
				 }
				 e++;
				 sum+=sequence[e];
							 
			 }else if(sum>k) {
				 if(s==sequence.length-1) {
					 break;
				 }
				 sum-=sequence[s];
				 s++;
				 
			 }
			 
			 
		 }
		// System.out.println("start index : "+start+" , end index : "+end);
		 
		 
		 
		 return new int[] {start,end};
	 }
	 
	

}
