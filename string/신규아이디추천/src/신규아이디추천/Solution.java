//package 신규아이디추천;

public class Solution {

//	public static void main(String[] args) {
//		Solution s=new Solution();
//		System.out.println( s.solution("...!@BaT#..y.abcdefghijklm"));
//	}
//	
	public String solution(String new_id) {
		
		return recommand(new_id);
		
	}
	
	public String recommand(String s) {
		//step1
		String step1=s.toLowerCase();
		System.err.println("step1 : "+step1);
		
		//step2
		String step2=step1.replaceAll("[^a-z0-9\\._-]", "");
		System.err.println("step2 : "+step2);
		//step3
		String step3=step2.replaceAll("\\.{2,}", ".");
		System.err.println("step3 : "+step3);
		//step4
		String step4=step3.replaceAll("^\\.|\\.$", "");
		System.err.println("step4: "+step4);
		
		
		String step5=step4;
		if(step5.isEmpty()) {
			step5="a";
		}
		System.err.println("step5 : "+step5);
		String step6=step5;
		
		
		if(step6.length()>=16) {
			step6=step6.substring(0, 15);
			step6=step6.replaceAll("\\.+$", "");
		}
		System.err.println("step6 : "+step6);
		
		String step7=step6;
		while(step7.length()<=2) {
			
			String bonus=step7.charAt(step7.length()-1)+"";
			step7=step7+bonus;
		}
		System.err.println("step7 : "+step7);
		
		return step7;
	}
//	
//	public boolean validCheck(String s) {
//		if(!s.matches(".{3,15}")) {
//			return false;
//		}
//		else if(s.matches("[^a-z0-9\\._-]+")) {
//			return false;
//		}
//		else if(s.startsWith(".")||s.endsWith(".")) {
//			return false;
//		}else if(s.matches(".*\\.{2,}.*")){
//			return false;
//		}
//		return true;
//	}

}
