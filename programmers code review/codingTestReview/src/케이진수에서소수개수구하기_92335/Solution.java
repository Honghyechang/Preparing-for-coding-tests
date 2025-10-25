package 케이진수에서소수개수구하기_92335;

import java.util.Arrays;

public class Solution {
//
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
//	s.solution(437674, 3);
//}

 public int solution(int n, int k) {
	 
	
	 
	 String str =Integer.toString(n, k);
	 //System.out.println(str);
	 str=str.replaceAll("0+", "0");
	 //System.out.println(str);
	 String split[]=str.split("0");
	 System.out.println(Arrays.toString(split));
	 int answer=0;
	 for(String s : split) {
		 
		 long p=Long.parseLong(s, 10);
		 if(isPrime(p)) {
			 answer++;
		 }
		 	 
	 }
	 System.out.println(answer);
	 return answer;
 }
 
 public boolean isPrime(long m) {
	 if(m==1) return false;
	 if(m==2) return true;
	 
	 for(long i=2; i<=Math.sqrt(m); i++) {
		 if(m%i==0) {
			 return false;
		 }
	 }
	 return true;
 }

}
