package day1;

public class Solution10 {

	
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//Solution10 s =new Solution10();
//s.solution("pYP");
//}
public boolean solution(String s) 
{
	s=s.toLowerCase();
	int acount=0;
	int bcount=0;
	for(int i=0; i<s.length(); i++) {
		char ch=s.charAt(i);
		if(ch=='y') {
			acount++;
		}else if(ch=='p') {
			bcount++;
		}
	}
	return acount==bcount;
}
}
