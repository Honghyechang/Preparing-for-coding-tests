package 모음사전;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {
	String str="AEIOU";
	List<String> list=new ArrayList<String>();
//	public static void main(String[] args) {
//Solution s=new Solution();
//System.out.println( s.solution("EIO"));
//
//	}
	
	public int solution(String word) {
		
		
		
		//AEIOU로 만들수 있는 모든 단어를 초기화하는 함수
		for(int i=0; i<str.length(); i++) {
			String start=str.substring(i,i+1);
			init(start,1);//start로 시작하는 5개 길이를 가진 단어만들기 1글자로 시작하는 
		}
		
		Collections.sort(list);
		
	
		return seekNumber(word);
	}
	
	public int seekNumber(String word) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(word)) {
				return i+1;
			}
		}
		return -1;
	}
	
	public void init(String start, int n) {
		//n은 현재 조합한 길이의 개수 단계
		
		
		//start시작하는 n개의 길이를 가진 단어만들기
		if(n>5) {
			return;
		}
		list.add(start);
		
		
		for(int i=0; i<str.length(); i++) {
			String start2=start+str.substring(i,i+1);
			init(start2,n+1);//start로 시작하는 5개 길이를 가진 단어만들기
		}
		
		
	}

}
