package 수식복원하기_340210;

import java.util.ArrayList;
import java.util.List;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
////		System.out.println(Integer.toString(51,8));
////		System.out.println(Integer.toString(5,8));
////		System.out.println(Integer.toString(44,8));
////		
////
////		System.out.println(Integer.valueOf("14",2));
////		System.out.println(Integer.valueOf("3",8));
////		System.out.println(Integer.valueOf("17",8));
////		
//		
//		String answer[]=s.solution(new String[] {"1 + 1 = 2", "1 + 3 = 4", "1 + 5 = X", "1 + 2 = X"});
//		for(String an: answer) {
//			System.out.println(an);
//		}
//	}
	
	 public String[] solution(String[] expressions) {
		 
		 
		 List<String> expressList=new ArrayList<String>();
		 List<String> questList=new ArrayList<String>();
		 for(String exp :expressions) {
			 if(exp.contains("X")) {
				 questList.add(exp);
			 }else {
				 expressList.add(exp);
			 }
		 }
		 
		 
		 //가능한 한 최소 진수값을 구해보자
		 int max=-1;
		 for(String exp :expressions) {
			 String changeExp=exp.replaceAll("\\D", "");
			 int n=StringMax(changeExp);
			 if(max < n ) {
				 max=n;
			 };
		 }
		 
		 //System.out.println(max + " max");
		 
		 List<Integer> possibleList=new ArrayList<Integer>();
		 for(int i=max+1; i<10; i++) {
			 boolean check=true;
			 
			 for(String exp : expressList) {
				 String split[]=exp.split(" ");
				 String a=split[0];
				 String b=split[2];
				 String op=split[1];
				 String answer=split[4];
				 
				
				 
				 
				 if(op.equals("+")) {
					 if(Integer.valueOf(a,i)+Integer.valueOf(b,i)!=Integer.valueOf(answer, i)) {
						 check=false;
						 break;
					 }
				 }else {
					 if(Integer.valueOf(a,i)-Integer.valueOf(b,i)!=Integer.valueOf(answer, i)) {
						 check=false;
						 break;
					 }
				 }
				 
			 }
			 
			 if(check) {
				 possibleList.add(i);
			 }
			 
		 }
		
		 
		 List<String> answerList=new ArrayList<String>();
		 
//		for(int n : possibleList)
//		{
//			System.err.println(n);
//		}
//		 
		 for(String exp : questList) {
			 String split[]=exp.split(" ");
			 String a=split[0];
			 String b=split[2];
			 String op=split[1];
			
			 boolean check=true;
			 String before="";
			 String current="";
			 for(int i=0; i<possibleList.size(); i++) {
				 int n=possibleList.get(i);
				 if(i==0) {
					 if(op.equals("+")) {
						 before=Integer.toString(Integer.valueOf(a, n) +Integer.valueOf(b, n), n); 
					 }else {

						 before=Integer.toString(Integer.valueOf(a, n) - Integer.valueOf(b, n), n); 
					 }
				 }else {
					 if(op.equals("+")) {
						 current=Integer.toString(Integer.valueOf(a, n) +Integer.valueOf(b, n), n); 
					 }else {

						 current=Integer.toString(Integer.valueOf(a, n) -Integer.valueOf(b, n), n); 
					 }
					 
					 if(!before.equals(current)) {
						 check=false;
						 break;
					 }
					 
					 
				 }
			 }
			 
			 if(check) {
				 answerList.add(exp.replaceAll("X", before+""));
			 }else {
				 answerList.add(exp.replaceAll("X", "?"));
			 }
			 
			 
		 }
		 
	
		 
		 String answer[]=answerList.stream()
				                   .toArray(String []::new);
		 
		 return answer;
	 }
	 
	 
	 public int StringMax(String str) {
		 int max=Integer.MIN_VALUE;
		 for(int i=0; i<str.length(); i++) {
			 int n=str.charAt(i)-'0';
			 if(n>max) {
				 max=n;
			 }
		 }
		 return max;
	 }

}
