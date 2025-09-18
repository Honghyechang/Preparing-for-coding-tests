package 외톨이알파벳;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution("edeaaabbccd");
//	}

	
	 public String solution(String input_string) {
		 
		 
		 for(int i=97; i<=122; i++) {
			 input_string=input_string.replaceAll((char)i+"+", (char)i+"");
			
		 }
		 System.out.println(input_string);
		 
		 Map<Character, Integer> maps=new HashMap<Character, Integer>();
		 
		 for(int i=0; i<input_string.length(); i++) {
			 char ch=input_string.charAt(i);
			 maps.merge(ch, 1,(currentValue, newValue)->currentValue+newValue);
		 }
		 
		 Set<Character> sets=maps.keySet() ;
		 List<String> answerList=new ArrayList<String>();
		 for(char ch : sets ) {
			 int value=maps.get(ch);
			 if(value>=2) {
				 answerList.add(ch+"");
			 }
		 }
		 
		 if(answerList.size()==0) {
			 return "N";
		 }
		 String answer=answerList.stream()
				    .sorted()
		 			.collect(Collectors.joining());
		 System.out.println(answer);
		 
		 
	  return answer;
	    }
}
