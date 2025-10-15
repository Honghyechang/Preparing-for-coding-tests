package 스킬트리_49993;

import java.util.HashSet;
import java.util.Set;

public class Solution {
//
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
//	String a="aa";
//	String b=a;
//	b="sss";
//	System.out.println(a);
//	
//	s.solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"});
//	}

	 public int solution(String skill, String[] skill_trees) {
		 
	
		Set<Character> charset=new HashSet<Character>();
		
		 for(int i=0; i<skill.length(); i++) {
			 
			 charset.add(skill.charAt(i));
			 

		 }
		 
		 int answer=0;
		 for(String skillTree : skill_trees) {
			 
			 
			 StringBuilder sb=new StringBuilder();
			 for(int i=0; i<skillTree.length(); i++) {
				 char ch=skillTree.charAt(i);
				 if(charset.contains(ch)) {
					 sb.append(ch);
				 }
			 }
			 
			
			 String word=sb.toString();
			// System.out.println(word);
			 
//			 if(sets.contains(word)) {
//				 answer++;
//			 }
			 if(skill.startsWith(word)) {
				 answer++;
			 }
			
			
			 
		 }
		 
		 System.out.println(answer);
		 return answer;
	 }

}
