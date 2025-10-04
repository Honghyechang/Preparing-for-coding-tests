package 완주하지못한선수_42576;

import java.util.HashMap;
import java.util.Map;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	public String solution(String participant[] , String completion[]) {
		Map<String,Integer> maps=new HashMap<String,Integer>();
		for(int i=0; i<participant.length; i++) {
			maps.merge(participant[i], 1, (a,b)->a+b);
		}
		
		for(int i=0; i<completion.length; i++) {
			int n=maps.get(completion[i]);
			if(n==1) {
				maps.remove(completion[i]);
			}else {
				maps.put(completion[i], n-1);
			}
		}
		
		for(String name : maps.keySet()) {
			return name;
		}
		return "";
	}
}
