package 문자열압축;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution s=new Solution();
		s.solution("abcabcdede");
	}
	
	public int solution(String s) {
		int min=Integer.MAX_VALUE; //가장 작은 값을 구하기.
		
		for(int i=1; i<=s.length(); i++) {
			//비교단위를 1 , 2, 3 ... 길이만큼 	
			StringBuilder sb=new StringBuilder();
			List<String> splitList=intSplit(s, i);
			String beforeStr=splitList.get(0);
			int num=1;
			for(int j=1; j<splitList.size(); j++) {
				
				String subStr=splitList.get(j);
				
				
				if(subStr.equals(beforeStr)) {
					num++;
				}else {
					if(num==1) {
						sb.append(beforeStr);
					}else {
						sb.append(num);
						sb.append(beforeStr);
						num=1;
					}
				}
				
				beforeStr=subStr;
			}
			
			//마지막 한번더 
			if(num==1) {
				sb.append(beforeStr);
			}else {
				sb.append(num);
				sb.append(beforeStr);
			}
			System.out.println("i값이 : "+i+"일 때, "+ sb.toString());
			
			if(min > sb.toString().length()) {
				min=sb.toString().length();
				System.out.println("최솟값 : "+min);
			}
			
		}
		
		
		return min;
	}
	
	//특정 숫자만큼 문자열을 잘라서 배열로 만드는 함수
	public List<String> intSplit(String str, int n){
		List<String> splitList=new ArrayList<String>();
		for(int i=0; i<str.length(); i=i+n) {
			if(i+n>str.length()) {
				splitList.add(str.substring(i));
			}else {
				splitList.add(str.substring(i,i+n));
			}
		}
		System.out.println(splitList);
		return splitList;
	}

}
