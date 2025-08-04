package 완주하지못한선수;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String solution(String participant[] , String completion[]) {
		Map<String,Integer> map =new HashMap<String,Integer>();
		
		for(int i=0; i<participant.length; i++) {
			String key=participant[i];
			if(map.get(key)==null) {
				map.put(key, 1);
			}else {
				map.put(key, map.get(key)+1);
			}
		}
		
		
		for(int j=0; j<completion.length; j++) {
			String key=completion[j];
			if(map.get(key)!=null) {
				map.put(key,map.get(key)-1);
			}
		}
		
		Set<String> set=map.keySet();
		Iterator<String> iterator=set.iterator();
		
		while(iterator.hasNext()) {
			String key=iterator.next();
			int value=map.get(key);
			
			if(value!=0) {
				return key;
			}
		}
		return "";
	}

}
