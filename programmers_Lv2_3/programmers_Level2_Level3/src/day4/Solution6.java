package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution6 {
	
	public int solution(int numbers[]) {
	
		List<Integer> numberList=Arrays.stream(numbers)
										.boxed()
										.collect(Collectors.toList());
		
		int sum=0;
		for(int i=0; i<10; i++) {
			if(!numberList.contains(i)) {
				sum+=i;
			}
		}
		
		return sum;
		
	}

}
