package 가장큰수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
	Set<String> strings=new HashSet<String>();

	public static void main(String[] args) {
		Solution s=new Solution();
		String st=s.solution( new int[] {6,10,2});
		
		
System.out.println(st);
	}
	
	public String solution(int numbers[]) {

		return Arrays.stream(numbers)
			  .boxed()
			  .map(i->i+"")
			  .sorted(
					  (v1,v2)->{
						  int n=Integer.parseInt(v1+v2);
						  int m=Integer.parseInt(v2+v1);
						  return m-n;
					  }
				)
			  .collect(Collectors.joining())
			  .replaceAll("^0+","0");
		
			  
		
	}
//
//	public void recurison(int array[],String str) {
//		System.out.println(Arrays.toString(array));
//		if(0==array.length) {
//			strings.add(str);
//			System.out.println(str);
//		}
//		for(int i=0; i<array.length; i++) {
//			String newStr=str+array[i];  //"ab" "ac"
//			//array를 현재 사용한 것 없애기
//			int a[]=Arrays.copyOfRange(array, 0, i);
//			int b[]=Arrays.copyOfRange(array, i+1, array.length);
//			
//			int[] newArray = IntStream.concat(Arrays.stream(a), Arrays.stream(b))
//                    .toArray();
//			recurison(newArray,newStr);
//		}
//	}
	
}
