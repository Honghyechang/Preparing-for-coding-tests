package day1;

public class Solution5 {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//Solution5 s=new Solution5();
//s.solution("a B z", 4);
//System.out.println((int)'z'+4-25);
//System.out.println((int)'z'+1-26);
//
//System.out.println((char)('z'+1-24));
//
//}

public String solution(String s, int n) {
	
	StringBuilder sb=new StringBuilder();
	for(int i=0; i<s.length(); i++) {
		char ch=s.charAt(i);
		if(ch==' ') {
			sb.append(' ');
		}else if(Character.isLowerCase(ch)) {
			ch=(char)(ch+n);
			if(!Character.isLowerCase(ch)) {
				ch=(char)(ch-26);
			}
			sb.append(ch);
		}
		else if(Character.isUpperCase(ch)) {
			ch=(char)(ch+n);
			if(!Character.isUpperCase(ch)) {
				ch=(char)(ch-26);
			}

			sb.append(ch);
		}
	}
	
	System.out.println(sb.toString());
	return sb.toString();
}

}
