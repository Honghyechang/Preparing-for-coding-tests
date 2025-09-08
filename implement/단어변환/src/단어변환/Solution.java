package 단어변환;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		s.solution("hit"	,"cog"	,new String[]{"hot", "dot", "dog", "lot", "log", "cog"}	);
//
//	}
//	
	 public int solution(String begin, String target, String[] words) {
		 
		 int answer=dfs(words,begin,target);
	     //   System.out.println(answer);
	        return answer;
	    }
	
	 public int dfs(String words[],String begin, String target) {
		 Set<String> visit=new HashSet<String>();
		 Queue<StringStep> queue=new LinkedList<StringStep>();
		 
		 int step=0;
		 visit.add(begin);
		 StringStep strstep=new StringStep(0, begin);
		 queue.add(strstep);
		 
		 while(!queue.isEmpty()) {
			 StringStep qss=queue.poll();
			 String word=qss.word;
			 int nextStep=qss.step+1;
			 
			 for(int i=0; i<words.length; i++) {
				 String wordStr=words[i];
				 if(visit.contains(wordStr))continue;
				 else {
					 if(check(word, wordStr)) {
						 
						 	//System.out.println("한글자 차이 : "+wordStr+" step : "+nextStep);
							 queue.add(new StringStep(nextStep, wordStr));
							 visit.add(wordStr); 
							 
							 if(wordStr.equals(target)) {
								 return nextStep;
							 }
					 }
				 }
			 }
		 }
		 return 0;
	 }
	 //한글자 차이
	 public boolean check(String str1,String str2) {
		 if(str1.length()!=str2.length())return false;
		 int count=0;
		 for(int i=0; i<str1.length();i ++) {
			 char a=str1.charAt(i);
			 char b=str2.charAt(i);
			 if(a!=b) {
				 count++;
			 }
		 }
		 
		 return count==1?true : false;
	 }
	 class StringStep{
		 int step;
		 String word;
		 public StringStep(int step,String word) {
			 this.step=step;
			 this.word=word;
		 }
	 }
}
