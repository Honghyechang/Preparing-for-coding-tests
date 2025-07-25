package 문자열내마음대로정렬하기;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		
		String re[]=s.solution(new String[] {"abce","abcd","cdx"},2);
		
		System.out.println(Arrays.toString(re));

	}

	public String[] solution(String strings[], int n) {
		Arrays.sort(strings,(v1,v2)->{
			
			if(v1.charAt(n)!=v2.charAt(n)) {
				return v1.charAt(n)-v2.charAt(n);
			}else {
				return v1.compareTo(v2);
			}
		}
		);
		return strings;
	}
 }
