package 문자열다루기기본;

public class Solution {

	public static void main(String[] args) {
		Solution s=new Solution();
		System.out.println(s.solution("15234"));
	}
	
	public boolean solution(String s) {
		
		return s.matches("[0-9]{4}|[0-9]{6}");
	}
}
