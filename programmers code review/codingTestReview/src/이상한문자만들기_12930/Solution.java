package 이상한문자만들기_12930;

import java.util.Arrays;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s= new Solution();
//s.solution("try hello     world");
//	}
	
	public String solution(String s) {
		StringBuilder sb=new StringBuilder();
		s=s.toLowerCase();
		//s=s.replaceAll("\\s+", " ");
		System.out.println(s);

			int index=0;		
	     for(int i=0; i<s.length(); i++) {
				char ch=s.charAt(i);
				if(ch==' ') {
					sb.append(ch);
					index=0;
					continue;
				}
				if(index%2==0) {
					
					ch=(char)(ch-32);
				}
				index++;
				sb.append(ch);
			}
			
		
		
		
		
		System.out.println(sb.toString());
		return sb.toString();
	}

}
