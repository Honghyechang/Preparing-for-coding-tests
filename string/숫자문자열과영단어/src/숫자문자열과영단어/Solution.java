package 숫자문자열과영단어;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Solution s=new Solution();
		s.solution("one4seveneight");

	}
	
	public int solution(String s) {
		
		HashMap<String, String> note=hashReset();
		
		Set<String> sets =note.keySet();
		Iterator<String> iterator=sets.iterator();
		
		while(iterator.hasNext()) {
			String key=iterator.next();
			System.out.println(key);
			System.out.println(note.get(key));
			
			
			if(s.contains(key)) {
				s=s.replace(key, note.get(key));
				System.out.println("대체");
			}
			
		}
		System.out.println(s);
		
		return 1;
	}
	
	public HashMap<String, String> hashReset(){
		HashMap<String, String> note=new HashMap<String, String>();
		note.put("zero", "0");
		note.put("one", "1");
		note.put("two", "2");
		note.put("three", "3");
		note.put("four", "4");
		note.put("five", "5");
		note.put("six", "6");
		note.put("seven", "7");
		note.put("eight", "8");
		note.put("nine", "9");
		return note;
	}

}
