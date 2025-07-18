package 신규아이디추천;

public class Solution {

	public static void main(String[] args) {
		Solution s=new Solution();
		System.out.println( s.solution("...!@BaT#..y.abcdefghijklm"));
	}
	
	public String solution(String new_id) {
		
		boolean check=validCheck(new_id);
		
		if(check) {
			return new_id;
		}
		else
		{
			String rename=recommand(new_id);
			return rename;
		}
		
	}
	
	public String recommand(String s) {
		//step1
		String step1=s.toLowerCase();
		System.err.println("step1 : "+step1);
		
		//step2
		String step2=step1.replaceAll("[^a-z^A-Z^1-9^\\.^-^_]", "");
		System.err.println("step2 : "+step2);
		//step3
		String step3=step2.replaceAll("\\.{2,}", ".");
		System.err.println("step3 : "+step3);
		//step4
		String step4_1=step3.replaceAll("^\\.", "");
		System.err.println("step4-1 : "+step4_1);
		String step4_2=step4_1.replaceAll("\\.$", "");
		System.err.println("step4-2 : "+step4_2);
		
		String step5=step4_2;
		if(step5.isEmpty()) {
			step5="a";
		}
		System.err.println("step5 : "+step5);
		String step6=step5;
		
		
		if(step6.length()>=16) {
			step6=step6.substring(0, 15);
			
			if(step6.endsWith(".")) {
				step6.replaceAll("\\.$", "");
			}
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
	
	public boolean validCheck(String s) {
		if(!s.matches(".{3,15}")) {
			return false;
		}
		else if(s.matches("[^a-z^A-Z^1-9^\\.^-^_]+")) {
			return false;
		}
		else if(s.startsWith(".")||s.endsWith(".")) {
			return false;
		}else if(s.matches(".*\\.{2,}.*")){
			return false;
		}
		return true;
	}

}
