package 숫자문자열과영단어_81301;

import java.util.HashMap;
import java.util.Map;

public class Solution {
//a.b -> acb adb
//a..b -> accb
//[abc] a or b or c
//[^abc] a b c가 아닌 부분
//[a-z]
//a+
//a*
//a?
//a{4}
	
//a{2,4}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		s.solution("23four5six7");
//
//	}
	public int solution(String s) {
		
//		0	zero
//		1	one
//		2	two
//		3	three
//		4	four
//		5	five
//		6	six
//		7	seven
//		8	eight
//		9	nine
		String english[]= {"zero","one","two","three","four","five","six","seven","eight","nine"};
		Map<String,String> map=new HashMap<String,String>();
		for(int i=0; i<english.length; i++) {
			map.put(english[i], i+"");
		}

		
		StringBuilder word=new StringBuilder();
		StringBuilder answer=new StringBuilder();
		
		for(String key : map.keySet()) {
			String value=map.get(key);
			
			s=s.replaceAll(key, value);
		}
		
		System.out.println(s);
		return Integer.parseInt(s);
	}
}
