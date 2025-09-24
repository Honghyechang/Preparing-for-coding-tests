package 모음사전_84512;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {

	Set<String> set=new TreeSet<String>();
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		s.solution("AAAAE");
//
//	}
	public int solution(String word) {
		
		String []aeiou= {"A","E","I","O","U"};
		setMake(aeiou,new ArrayList<String>());
		
		int answer=1;
		for(String str : set) {
			System.out.println(str);
			if(word.equals(str)) {
				System.out.println(answer);
				return answer;
			}
			answer++;
		}
		
		return -1;
	}
	
	public void setMake(String[] aeiou,List<String> lists) {
		
		if(lists.size()<=5 && lists.size()>0) {
			String word=lists.stream()
							 .collect(Collectors.joining());
			if(!set.contains(word)) {
				set.add(word);
			//	System.out.println(word);
			}
			
			if(lists.size()==5) {
				return;
			}
		
		}
		
		for(int i=0; i<aeiou.length; i++) {
			String str=aeiou[i];
			List<String> newList=new ArrayList<String>(lists);
			newList.add(str);
			setMake(aeiou,newList);
		}
		
		
	}

}
