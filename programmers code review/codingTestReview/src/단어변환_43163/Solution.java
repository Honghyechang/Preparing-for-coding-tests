package 단어변환_43163;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
//	
//	s.solution("hit"	,"cog"	,new String[]{"hot", "dot", "dog", "lot", "log", "cog"}	);
//
//}

 public int solution(String begin, String target, String[] words) {
	 
	 Word[] wordArr=new Word[words.length];
	 
	 for(int i=0; i<wordArr.length; i++) {
		 wordArr[i]=new Word(words[i]);
	 }
	 
	 boolean visited[]=new boolean[words.length];
	 
	 Queue<Word> queue=new LinkedList<Word>();
	 Word word=new Word(begin);
	 word.setStep(0);
	 queue.add(word);
	 
	 while(!queue.isEmpty()) {
		 Word w=queue.poll();
		 int nextStep=w.step+1;
		 
		 for(int i=0; i<wordArr.length; i++) {
			 if(visited[i])continue;
			 //한개 차이인지 확인
			 Word compare=wordArr[i];
			 if(check(w,compare )) {
				 
				 if(compare.word.equals(target)) {
					 System.out.println(nextStep);
					 return nextStep;
				 }
				 
				 compare.setStep(nextStep);
				 visited[i]=true;
				 queue.add(compare);
			 }
		 }
		 
	 }
	 System.out.println("0");
	 return 0;
	 
	 
 }
 
 public boolean check(Word one, Word two) {
	 String oneStr=one.word;
	 String twoStr=two.word;
	
	 int count=0;
	 for(int i=0; i<oneStr.length(); i++ ) {
		 char a=oneStr.charAt(i);
		 char b=twoStr.charAt(i);
		 
		 if(a==b) {
			 count++;
		 }
	 }
	 
	 return count==oneStr.length()-1;
 }
 class Word{
	 String word;
	 int step;
	 public Word(String word) {
		 this.word=word;
	 }
	 public void setStep(int step) {
		 this.step=step;
	 }
 }

}
