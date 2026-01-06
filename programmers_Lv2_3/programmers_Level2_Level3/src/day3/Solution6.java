package day3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution6 {
	public static void main(String[] args) {
	Solution6 s=new Solution6();
	String st=s.solution( new int[] {6,10,2});
	
	
		System.out.println(st);
	}

	public String solution(int numbers[]) {
		
		String result=Arrays.stream(numbers)
			  .mapToObj(i->i+"")
			  .sorted((a,b)->{
				
				  
				  int result1=Integer.parseInt(a+b);
				  int result2=Integer.parseInt(b+a);
				  
				 return result2-result1;
				  
			  })
			  .collect(Collectors.joining())
			  .replaceAll("^0+","0");
			  
		System.out.println(result);
		return result;
		
		
	}

}
