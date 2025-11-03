package 외톨이알파벳_121683;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//	Solution s=new Solution();
//	s.solution("edeaaabbccd");
//}


 public String solution(String input_string) {
	 
	 
	 char chars[]= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	 for(int i=0; i<chars.length; i++) {
		 input_string=input_string.replaceAll(chars[i]+"+", chars[i]+"");
	 }
	 
	 Map<Character,Integer> map=new HashMap<Character, Integer>();
	 for(int i=0;i<input_string.length(); i++) {
		 char ch=input_string.charAt(i);
		 map.merge(ch, 1, (a,b)->a+b);
	 }
	 
	 String answer="";
	 for(char key : map.keySet()) {
		 int value=map.get(key);
		 if(value>=2) {
			 answer=answer+key;
		 }
	 }
	 if(answer.equals("")) {
		 return "N";
	 }
	 //System.out.println(answer);
	 answer=answer.chars()
			      .sorted()
			      .mapToObj((a)->(char)a+"")
			      .collect(Collectors.joining());
			      
	 return answer;
	 
 }
 



}
