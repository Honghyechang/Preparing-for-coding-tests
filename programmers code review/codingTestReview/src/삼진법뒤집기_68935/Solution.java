package 삼진법뒤집기_68935;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(45);
//	}

	public int solution(long n) {
		StringBuilder sb=new StringBuilder(Long.toString(n,3));
		String answerStr=sb.reverse().toString();
		System.out.println(answerStr);

		
		//anser ->10집법
		
		int a=Integer.valueOf(answerStr, 3);
		System.out.println(a);
		return a;
	}
}
