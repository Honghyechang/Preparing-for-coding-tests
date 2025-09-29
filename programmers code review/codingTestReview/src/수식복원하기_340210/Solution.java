package 수식복원하기_340210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		String str="51 - 5 = 44";
////		int a=51;
////		int b=5;
////		int c=44;
////		
////		System.out.println(Integer.parseInt(a+"", 8));
////		System.out.println(Integer.parseInt(b+"", 8));
////		System.out.println(Integer.parseInt(c+"", 8));
////		System.out.println(Integer.toString(a, 8));
////		System.out.println(Integer.toString(b, 8));
////		System.out.println(Integer.toString(c, 8));
////		System.out.println();
//		
////		OptionalInt arr="1234".chars()
////			  .map(i->i-'0')
////			  .max();
////		if(arr.isPresent()) {
////			System.out.println(arr.getAsInt());
////		}
////			   
////		//System.out.println(arr);
//		
////		
//		Solution s=new Solution();
//		s.solution(new String[] {"1 + 1 = 2", "1 + 3 = 4", "1 + 5 = X", "1 + 2 = X"});
//
//	}
//	
	   public String[] solution(String[] expressions) {
		    
		   //x가 아닌 exp
		   String nonX[]=Arrays.stream(expressions)
				   			   .filter((str)->!str.contains("X"))
				   			   .toArray(String[]::new);
		   
		   String containX[]=Arrays.stream(expressions)
	   			   .filter((str)->str.contains("X"))
	   			   .toArray(String[]::new);
		   
		   List<Integer> matchRadix=new ArrayList<Integer>();
		   
		   
		   //containX 의 숫자 최대값을 구해보자
		   int containMax=Integer.MIN_VALUE;
		   for(String conX :containX) {
			   int getMax=conX.chars()
					   		  .filter(i->Character.isDigit(i))
					   		  .map((j)->j-'0')
					   		  .max()
					   		  .orElse(-1);
			   if(getMax>containMax) {
				   containMax=getMax;
			   }
		   }
		//   System.out.println("containMax : "+containMax);
		  // System.out.println("nonX "+nonX.length);
//		   for(String none : nonX) {
//			   System.out.println(none);
//		   }
//		   System.out.println("==");
		   
		   for(int i=containMax+1; i<=9; i++) {
			
			   int matchCount=0;
			   for(int j=0; j<nonX.length; j++) {
				   
				   String nonXexp=nonX[j];
				  // System.out.println(nonXexp);
				   String exps[]=nonXexp.split(" ");
				   
				   //모든 자리에서 각 원소의 최대값을 구하기
				   String maxStr=exps[0]+exps[2]+exps[4];
				   OptionalInt max=maxStr.chars()
								         .map(a->a-'0')
								         .max();
				   
				   int maxSize=-1;
				   if(max.isPresent()) {
					   maxSize=max.getAsInt();
			//		   System.out.println(maxSize+" maxsize");
				   }
				   
				   if(maxSize >= i) {
					   break;
					   
				   }
						   		 
			//	   System.out.println(maxSize + nonXexp + "현재 i : "+i);
				   
				   
				   int ex1=Integer.parseInt(exps[0],i);
				   int ex2=Integer.parseInt(exps[2],i);
				   int ex3=Integer.parseInt(exps[4],i);
				   
				   int answer=0;
				   if(exps[1].equals("+")) {
					   answer=ex1+ex2;
				   }else if(exps[1].equals("-")) {
					   answer=ex1-ex2;
				   }
				   
				   if(answer==ex3) {
					   matchCount++;
				   }
				   
			   }
			   
			   if(matchCount==nonX.length) {
				   matchRadix.add(i);
			   }
			   
			   
		   }
		   
		   
//		   for(int i:matchRadix) {
//			   System.out.println(i);
//		   }
//		   
		   String[] answer = new String[containX.length];
		   for(int i=0; i<containX.length; i++) {
			   String containeExp=containX[i];
			   String exps[]=containeExp.split(" ");
			   
			  // System.out.println(containeExp+" 단계");
			   String beforeCal="";
			   boolean isEqual=true;
			   for(int j=0; j<matchRadix.size(); j++) {
				   int radix=matchRadix.get(j);
				   
				   int ex1=Integer.parseInt(exps[0],radix);
				   int ex2=Integer.parseInt(exps[2],radix);
				   int calInt=exps[1].equals("+")?ex1+ex2 : ex1-ex2;
				   String cal=Integer.toString(calInt, radix);
				   
				   if(j==0) {
					   beforeCal=cal;
					//   System.out.println("최초 업데이트 : "+beforeCal);
				   }else {
					   if(!beforeCal.equals(cal)) {
						//   System.out.println("결과다름 : "+beforeCal);
						   isEqual=false;
						   break;
					   }
				   }
				   
			   }
			   
			   if(isEqual) {
				   
				   answer[i]=containeExp.replace("X", beforeCal+"");
			   }else {
				   answer[i]=containeExp.replace("X", "?");
			   }
			   
			   
		   }
		//   System.out.println(Arrays.toString(answer));
		   
	        
	        return answer;
	    }

}
