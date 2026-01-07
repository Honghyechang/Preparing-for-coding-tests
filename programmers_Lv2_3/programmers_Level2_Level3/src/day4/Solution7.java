package day4;

import java.util.HashMap;
import java.util.Map;

public class Solution7 {
	
	public String solution(String participant[] , String completion[]) {

		Map<String,Integer> maps=new HashMap<String, Integer>();
		for(String name : participant) {
			maps.merge(name,1,(a,b)->a+b);
		}
		
		for(String name : completion) {
		 if(maps.get(name)==1) {
			 maps.remove(name);
		 }else {
			 maps.put(name, maps.get(name)-1);
		 }
		}
		
		for(String key : maps.keySet()) {
			return key;
		}
		return null;
		
	}

}
