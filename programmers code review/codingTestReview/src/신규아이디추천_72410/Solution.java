package 신규아이디추천_72410;

public class Solution {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub\
//		Solution s=new Solution();
//		s.solution("...!@BaT#*..y.abcdefghijklm");
//	}
	
	public String solution(String new_id) {
		
		//step1
		new_id=new_id.toLowerCase();
		//System.out.println(new_id);
		//step2
		new_id=new_id.replaceAll("[^a-z\\d\\-_\\.]","");
		//System.out.println(new_id);
		//step3
		new_id=new_id.replaceAll("\\.+", ".");
		//System.out.println(new_id);
		//step4
		new_id=new_id.replaceAll("^\\.+|\\.+$", "");
		//System.out.println(new_id);
		//step5
		new_id=new_id.equals("") ? "a" : new_id;
		//System.out.println(new_id);
		//step6
		new_id=new_id.length() >=16 ? new_id.substring(0, 15) : new_id;
		new_id=new_id.replaceAll("\\.+$", "");
		//System.out.println(new_id);
		//step7
		if(new_id.length()<=2) {
			String str=new_id.charAt(  new_id.length()-1 )+"";
			while(new_id.length()!=3) {
				new_id=new_id+str;
			}
		}
		
		System.out.println(new_id);
				
				
				
				
				
		return new_id;
	}

}
