package 두개뽑아서더하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution s=new Solution();
		
	}
	
	public int[] solution(int numbers[]) {
		
		Set<Integer> set=new HashSet<Integer>();
		Set<Integer> result=recurion(0,numbers,set);
		List<Integer> resultList=new ArrayList<Integer>(result); //set -> list
		Collections.sort(resultList);
		int resultArray[]=resultList
							.stream()
							.mapToInt(x->x.intValue())
							.toArray();
		Arrays.sort(resultArray);
		return resultArray;
		
	}

	public Set<Integer> recurion(int index,int array[],Set<Integer> result) {
		
		
		if(index==array.length)return result;
		
		for(int i=index+1;i<array.length; i++ )
		{
			int m= array[index]+array[i];
			result.add(m);
		}
		return recurion(index+1, array,result);
	}
}
