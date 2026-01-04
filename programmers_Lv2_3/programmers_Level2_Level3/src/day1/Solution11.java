package day1;

import java.util.HashMap;
import java.util.Map;

public class Solution11 {
	public int solution(String s) {
		
	Map<String,String> map=new HashMap<String,String>();
	map.put("zero", "0");
	map.put("one", "1");
	map.put("two", "2");
	map.put("three", "3");
	map.put("four", "4");
	map.put("five", "5");
	map.put("six", "6");
	map.put("seven", "7");
	map.put("eight", "8");
	map.put("nine", "9");
	map.put("ten", "10");
	
	for(String key: map.keySet()) {
		String value=map.get(key);
		s=s.replaceAll(key,value);
	}
	
	return Integer.parseInt(s);
	
	}
}
