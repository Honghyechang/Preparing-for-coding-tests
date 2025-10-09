package 가장큰수_42746;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {


		public String solution(int numbers[]) {
			
			String numberString=Arrays.stream(numbers)
										.mapToObj(i->i+"")
										.sorted((a,b)->{
											
											long first=Long.parseLong(a+b);
											long second=Long.parseLong(b+a);
											
											return (int)(second-first);
											
										})
										.collect(Collectors.joining());
			//System.out.println(numberString);
			
			if(numberString.matches("0+")) {
				numberString="0";
			}
			return numberString;
		}
		
		

}
