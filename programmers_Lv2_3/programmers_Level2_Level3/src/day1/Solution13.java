package day1;

public class Solution13 {
	
	public static void main(String args[]) {
		Solution13 s=new Solution13();
		s.solution("...!@BaT#*..y.abcdefghijklm");
		s.solution("z-+.^.");
		s.solution("=.=");
	}
	
	public String solution(String new_id) {
		
		String s=new_id;
		
		s=s.toLowerCase();
		
		
		s=s.replaceAll("[^a-z0-9\\-_.]", "");
		
		s=s.replaceAll("\\.+", ".");
		
		s=s.replaceAll("^\\.+", "");
		s=s.replaceAll("\\.+$", "");
		
		if(s.equals("")) {
			s="a";
		}
		
		if(s.length()>=16) {
			s=s.substring(0,15);
		}
		s=s.replaceAll("\\.+$","");
		
		if(s.length()<=2) {
			String last=s.charAt(s.length()-1)+"";
			while(s.length()<3) {
				s=s+last;
			}
		}
		
		System.out.println(s);
		return s;
	}
}
