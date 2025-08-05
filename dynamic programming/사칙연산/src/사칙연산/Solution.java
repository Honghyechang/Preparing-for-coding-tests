package 사칙연산;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
	
	List<Integer> answers=new ArrayList<Integer>();
	
	Map<String,Integer> answerMap=new HashMap<String,Integer>();
	
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s=new Solution();
//int n=s.solution(new String[] {"1","-","3","+","5","-","8"});
//System.out.println(n);
//	}
	
	 public int solution(String arr[]) {
		 
		 List<String> list=Arrays.stream(arr)
				 				 .collect(Collectors.toList());
	
		 recursion(list);
		 
		 
	        return max();
	    }
	 
	 
	 public int max() {
		 int m=Integer.MIN_VALUE;
		 for(int i=0; i<answers.size(); i++) {
			 if(m<answers.get(i)) {
				 m=answers.get(i);
			 }
		 }
		 return m;
	 }
	 public int recursion(List<String> list) {
		 
		// System.out.println(list.toString()+"!!");
		 String join=String.join(",", list);
		 if(list.size()==1) {
			 answers.add(Integer.parseInt(list.get(0)));
			 //System.out.println("결과 : "+ list.get(0));
			 
			 answerMap.put(join, Integer.parseInt(list.get(0)));
			 return Integer.parseInt(list.get(0));
		 }
		 
		 
		 if(answerMap.get(join)!=null) {
			 return answerMap.get(join);
		 }
		 
		 int max=Integer.MIN_VALUE;
		 
		 for(int i=0; i<list.size()-2; i=i+2) {
			 int a=Integer.parseInt(list.get(i));
			 String op =list.get(i+1);
			 int b=Integer.parseInt(list.get(i+2));
			 
			 String cal=calculate(a, op, b);
			 //System.out.println("use : "+ a+op+b+" = "+cal);
			 
			 
			 List<String> newList=new ArrayList<String>();
			 newList.addAll(list.subList(0, i));
			 newList.add(cal);
			 newList.addAll(list.subList(i+3,list.size()));
			
			 int n=recursion(newList);
			 if(n>max) {
				 max=n;
			 }
		 }
		 answerMap.put(join, max);
		 return max;

	 }
	
	 
	 public String calculate(int a, String op, int b) {
		 
		 
		 switch (op) {
				case "+": {
					int sum = a+b;
					return sum+"";
				}
				case "-":{
					int min=a-b;
					return min+"";
				}
				default :
					return "";
		 }
	 }
	 
	 public boolean isNumber(String str) {
		 return str.matches("\\d+");
	 }

}
