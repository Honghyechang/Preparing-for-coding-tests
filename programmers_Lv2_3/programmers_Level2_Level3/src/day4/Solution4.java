package day4;

import java.util.HashSet;
import java.util.Set;

public class Solution4 {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//}

public String solution(String my_string) {
Set<Character> sets=new HashSet<Character>();
StringBuilder sb=new StringBuilder();
for(char ch : my_string.toCharArray()) {
	if(sets.contains(ch)) {
		continue;
	}else {
		sb.append(ch);
		sets.add(ch);
	}
	
}
System.out.println(sb.toString());
return sb.toString();
}
}
