package day4;

import java.util.stream.Collectors;

public class Solution5 {
	public int solution(String before, String after) {
	
		
		before=before.chars()
			  .sorted()
			  .mapToObj(i->(char)i+"")
			  .collect(Collectors.joining());
		
		after=after.chars()
				  .sorted()
				  .mapToObj(i->(char)i+"")
				  .collect(Collectors.joining());
		
		
		
		return before.equals(after)? 1:0;
		
	}
}
