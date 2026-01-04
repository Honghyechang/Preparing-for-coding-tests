package day1;

public class Solution8 {
	
//	public static void main(String args[]) {
//		Solution8 s=new Solution8();
//		System.out.println(s.solution(45));
//	}
	
	public int solution(long n) {
	StringBuilder sb=new StringBuilder(Long.toString(n, 3));
	return Integer.parseInt(sb.reverse().toString(), 3);
	}
}
