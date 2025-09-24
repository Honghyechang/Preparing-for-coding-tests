package 이진변환반복하기_70129;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution("110010101001");
//	}

	public int[] solution (String s) {
		List<Integer> list=new ArrayList<Integer>();
		while(!s.equals("1")) {
			String zeroRemove=s.replaceAll("0++", "");
			int n=s.length()-zeroRemove.length();
			list.add(n);
			
			s=Integer.toString(zeroRemove.length(),2);
		
		}
		
		int sum=list.stream()
					     .mapToInt((i)->i.intValue())
					     .sum();
		
		
		System.out.println(list.size()+","+sum);
		int answer[]= {list.size(),sum};
		return answer;
	}
}
