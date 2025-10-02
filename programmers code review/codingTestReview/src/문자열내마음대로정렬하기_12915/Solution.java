package 문자열내마음대로정렬하기_12915;

import java.util.Arrays;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
//	
//	String re[]=s.solution(new String[] {"abce","abcd","cdx"},2);
//	
//	System.out.println(Arrays.toString(re));
//
//}

public String[] solution(String strings[], int n) {
	
	strings=Arrays.stream(strings)
				  .sorted((a,b)->{
					  
					  char aCh=a.charAt(n);
					  char bCh=b.charAt(n);
					  if(aCh==bCh) {
						  return a.compareTo(b);
					  }else {
						  return aCh-bCh;
					  }
					  
				
					  
					  
				  })
				  .toArray(String[]::new);
	System.out.println(Arrays.toString(strings));
	return strings;
	
	
}

}
