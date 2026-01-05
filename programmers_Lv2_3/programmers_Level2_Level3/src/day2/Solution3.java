package day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution3 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Solution3 s=new Solution3();
	int n=s.solution("I");
System.out.println(n);
}
	
	List<String> answerList=new ArrayList<String>();
	
public int solution(String word) {
	createWord(new char[] {'A','E','I','O','U'},0,new char[5]);
	Collections.sort(answerList);
	return answerList.indexOf(word);
	
	
}

public void createWord(char[] word, int index , char[] selectchar) {
	
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<index; i++) {
			sb.append(selectchar[i]);
		}
	
		answerList.add(sb.toString());
		
		
		if(index==5) {
			return;
		}
	
	
	
	for(int i=0; i<word.length; i++) {
		selectchar[index]=word[i];
		createWord(word,index+1,selectchar);
	}
}

}
