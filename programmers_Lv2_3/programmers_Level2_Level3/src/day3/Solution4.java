package day3;

import java.util.Arrays;

public class Solution4 {
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution4 s=new Solution4();
//	
//	String re[]=s.solution(new String[] {"abce","abcd","cdx"},2);
//	
//	System.out.println(Arrays.toString(re));
//
//}

public String[] solution(String strings[], int n) {

	Arrays.sort(strings,(a,b)->{
		if(a.charAt(n)!=b.charAt(n)) {
			return a.charAt(n)-b.charAt(n);
		}else {
			return a.compareTo(b);
		}
		
	});
	
	//System.out.println(Arrays.toString(strings));
	return strings;

}
}
