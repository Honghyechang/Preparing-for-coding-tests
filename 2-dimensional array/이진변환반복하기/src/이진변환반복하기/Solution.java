package 이진변환반복하기;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Solution s=new Solution();
int result[]=s.solution("110010101001");
System.out.println(result[0] +" , " + result[1]);
	}
	
	public int[] solution (String s) {
		
		int zeroCount=0;
		int changeCount=0;
		
		while(!s.equals("1")) {
			int currentLeng=s.length();
			s=s.replace("0", "");
			int replaceLeng=s.length();
			
			zeroCount+=currentLeng-replaceLeng;
			
			
			s=Integer.toString(replaceLeng,2);
			changeCount++;
		}
		int result[]= {changeCount,zeroCount};
		
		return result;
		
	}
	
	

}
