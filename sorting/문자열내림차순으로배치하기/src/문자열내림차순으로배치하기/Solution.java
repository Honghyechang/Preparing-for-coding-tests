package 문자열내림차순으로배치하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {


	public String solution(String s) {
		
		String str=s.chars()
		 .boxed()
		 .sorted((v1,v2)->v2-v1)
		 .map(i->(char)(int)i + "")
		 .collect(Collectors.joining());
		return str;
	}

}
