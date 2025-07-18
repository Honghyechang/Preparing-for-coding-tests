package 이상한문자만들기;


public class Solution {

	
	public String solution(String s) {
		
		StringBuilder result=new StringBuilder();
		int reset=0;
		for(int i=0; i<s.length(); i++) {
			char ch=s.charAt(i);
			if(ch==' ') {
				result.append(ch);
				reset=0;
			}else {
				if(reset%2==0) {
					result.append(Character.toUpperCase(ch));
					reset++;
				}else {
					result.append(Character.toLowerCase(ch));
					reset++;
				}
			}
		
		}
		return result.toString();
	}

}
