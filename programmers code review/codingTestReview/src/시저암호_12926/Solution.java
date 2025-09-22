package 시저암호_12926;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution("a B z", 4);
//	}

	public String solution(String s, int n) {
		
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<s.length(); i++) {
			char ch=s.charAt(i);
			if(ch==' ') {
				sb.append(' ');
				continue;
			}
			
			for(int m=0; m<n; m++) {
				//n번
				if(ch=='z') {
					ch='a';
				}else if(ch=='Z') {
					ch='A';
				}else {
					ch=(char)(ch+1);
				}
			}
			
			sb.append(ch);
		}
		
		System.out.println(sb.toString());
		return sb.toString();
	}
}
