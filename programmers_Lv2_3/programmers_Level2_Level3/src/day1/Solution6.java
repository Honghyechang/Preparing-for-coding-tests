package day1;

public class Solution6 {

	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
Solution6 s= new Solution6();
s.solution("try hello     world");
//		System.out.println(" s      s ss".replaceAll("\\s+"," "));
}

public String solution(String s)
{
	
	StringBuilder sb=new StringBuilder();
	int index=0;
	for(int i=0; i<s.length();i++) {
		if(s.charAt(i)==' ') {
			sb.append(' ');
			index=0;
		}else {
			char ch=s.charAt(i);
			if(index%2==0) {
				ch=Character.toUpperCase(ch);
			}else {
				ch=Character.toLowerCase(ch);
			}
			sb.append(ch);
			index++;
		}
	}
	
	System.out.println(sb.toString());
	return sb.toString();
}
}
