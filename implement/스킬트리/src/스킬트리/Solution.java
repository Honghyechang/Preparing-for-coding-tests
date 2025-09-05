package 스킬트리;

import java.util.Arrays;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		String a="aa";
//		String b=a;
//		b="sss";
//		System.out.println(a);
//		
//		s.solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"});
//
//	}
//	
	 public int solution(String skill, String[] skill_trees) {
		 
		 int count=0;
		    	for(int j=0; j<skill_trees.length; j++) {
		    		String tree=skill_trees[j];
		    		String replace=tree.replaceAll("[^"+skill+"]", "");
		    		
		    		if(skill.startsWith(replace)) {
		    			count++;
		    		}
		    		
		    	}
		    	return count;
	    }

}
