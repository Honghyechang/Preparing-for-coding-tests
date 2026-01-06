package day3;

import java.util.stream.Collectors;

public class Solution5 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
Solution5 s=new Solution5();
s.solution("Zbcdefg");
}

public String solution(String s) {

	String str=s.chars()
	 .mapToObj(i->(char)i+"")
	 .sorted((a,b)->b.compareTo(a))
	 .collect(Collectors.joining());
	//System.out.println(str);
	return str;
}
}
