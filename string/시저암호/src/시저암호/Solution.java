package 시저암호;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Solution s=new Solution();
System.out.println(s.solution("a B z", 4));
	}
	
	public String solution(String s, int n) {
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0; i<s.length(); i++){
			
			char ch=s.charAt(i);
			if(ch!=' ') {
				char UpperOrLower=Character.isUpperCase(ch)? 'A' : 'a';
				int offset=ch-UpperOrLower;
				int push=(offset+n)%('Z'-'A'+1);
				System.out.println(push);
				char resultCh=(char)(UpperOrLower+push);
				System.out.println(resultCh);
				sb.append(resultCh);
			}
			else {
				sb.append(ch);
			}
			
	
			
		}
		return sb.toString();
	}

}
