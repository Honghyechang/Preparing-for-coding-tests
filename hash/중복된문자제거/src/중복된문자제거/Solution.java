package 중복된문자제거;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Solution s=new Solution();
s.solution("peo ple");
	}
	
	public String solution(String my_string) {
		
		String str="";
		Set<Character> set=new HashSet<Character>();
		for(int i=0; i<my_string.length(); i++) {
			char ch=my_string.charAt(i);
			if(!set.contains(ch)) {
				set.add(ch);
				str+=ch+"";
			}
		}
		return str;
	}

}
