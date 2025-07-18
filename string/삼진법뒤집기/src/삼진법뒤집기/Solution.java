package 삼진법뒤집기;

public class Solution {

	public static void main(String args[]) {
		Solution s =new Solution();
		int n=s.solution(45);
		System.out.println(n);
	}
	
	public int solution(long n) {
		
		
		
		String str=Long.toString(n,3);	
		StringBuilder sb=new StringBuilder(str);
		sb.reverse();
		return Integer.parseInt(sb.toString(),3);
		
	}

}
