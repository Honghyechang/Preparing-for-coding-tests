package 중복된문자제거_120888;

import java.util.HashSet;
import java.util.Set;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	
	public String solution(String my_string) {
		Set<Character> sets=new HashSet<Character>();
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<my_string.length(); i++) {
			char ch=my_string.charAt(i);
			if(!sets.contains(ch)) {
				sets.add(ch);
				sb.append(ch);
			}
		}
		return sb.toString();
		
	}

}
