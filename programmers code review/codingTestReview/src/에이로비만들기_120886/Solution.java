package 에이로비만들기_120886;

import java.util.stream.Collectors;

public class Solution {
	public int solution(String before, String after) {
		
		before=before.chars()
					 .sorted()
					 .mapToObj(i->i+"")
					 .collect(Collectors.joining());
		
		after=after.chars()
				 .sorted()
				 .mapToObj(i->i+"")
				 .collect(Collectors.joining());
		
		return before.equals(after) ? 1: 0;
	}
}
