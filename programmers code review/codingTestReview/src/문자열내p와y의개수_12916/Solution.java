package 문자열내p와y의개수_12916;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s =new Solution();
//s.solution("pYP");
//	}
	public boolean solution(String s) {
		
		
		int pCount=s.length() - s.replaceAll("[pP]", "").length();
		int yCount=s.length() - s.replaceAll("[yY]", "").length();
		
		if(pCount==0 && yCount==0) {
			return true;
		}
		
		if(pCount==yCount) {
			return true;
		}else {
			return false;
		}
	}

}
