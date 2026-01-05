package day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution5 {
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Solution5 s=new Solution5();
	System.out.println(Arrays.toString(s.solution(10, 2)));


}
public int[] solution(int brown, int yellow) 
{
	List<int[]> possibleList=new ArrayList<int[]>();
	
	//약수 조합 구하기
	//가로가 더 클것
	for(int i=1; i<=Math.sqrt(yellow); i++) {
		if(yellow%i==0) {
			//소수 기억하기
			int arr[]=new int[] {i,yellow/i};
			Arrays.sort(arr);;
			possibleList.add(arr);
		}
	}
	
	for(int[]arr: possibleList) {
		int seroSize=arr[0];
		int garoSize=arr[1];
		System.out.println("가로 : "+garoSize+ " , 세로 : "+seroSize);
		
		int brownSize=( (garoSize+2)*(seroSize+2) ) - seroSize*garoSize;
		if(brownSize==brown) {
			return new int[] {garoSize+2,seroSize+2};
		}
	}
	return null;
}

}
