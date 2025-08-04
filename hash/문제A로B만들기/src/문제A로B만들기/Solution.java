package 문제A로B만들기;
import java.util.HashMap;
import java.util.Map;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		int n=s.solution("alepp", "apple");
//		System.out.println(n);
//	}

	public int solution(String before, String after) {
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		
		for(int i=0; i<before.length(); i++) {
			char ch=before.charAt(i);
			if(map.get(ch)==null) {
				map.put(ch, 1);
			}else {
				int value=map.get(ch)+1;
				map.put(ch, value);
			}
		}
		
		
		for(int i=0; i<after.length(); i++) {
			char ch=after.charAt(i);
			if(map.get(ch)==null) {
				return 0;
			}else if(map.get(ch)==0) {
				return 0;
			}
			else {
				int value=map.get(ch)-1;
				map.put(ch, value);
			}
		}
		return 1;
	}
}

