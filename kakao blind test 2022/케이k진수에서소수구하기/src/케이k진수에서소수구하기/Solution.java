package 케이k진수에서소수구하기;

import java.util.Arrays;

public class Solution {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		s.solution(797161, 3);
//	}
	
	 public int solution(int n, int k) {
		 
		 String ratioBit=Integer.toString(n, k);
		 ratioBit=ratioBit.replaceAll("0+", "0");
		 // 0ㅇ 중간에 이어져있으면 00000->0으로 바꿀줄 알아야한다.
//		 String test="ssssttss+++++ts";
//		 String t=test.replaceAll("\\++", "4");
//		 System.out.println(t);
		 
		 //System.out.println("test : "+Arrays.toString("4".split("0")) + "size : "+"11012".split("0").length);
		 
		 String splitArr[]=ratioBit.split("0");
		 
		// System.out.println(ratioBit);
		 //System.out.println(Arrays.toString(splitArr));
		 int answer = 0;
		 for(int i=0; i<splitArr.length; i++) {
			 if(isPrimenumber(splitArr[i])) {
				 answer++;
			 }
		 }
	      System.out.println(answer); 
	     return answer;
	 }
	 
	 public boolean isPrimenumber(String numberStr) {
		 Long number=Long.parseLong(numberStr);
		 int checkCount=0;
		 
		 if(number==1) return false;
		 for(long i=2; i<=Math.sqrt(number); i++) {
			 if(number%i==0) {
				 return false;
			 }
		 }
		 return true;
		 
	 }

}
