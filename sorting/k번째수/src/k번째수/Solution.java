package k번째수;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		int a[]= {1,5,2,6,3,7,4};
		int b[][]= {
				{2,5,3},{4,4,1},{1,7,3}
		};
		int n[]=s.solution(a,b);
		System.out.println(Arrays.toString(n));

	}
	public int[] solution(int array[],int commands[][]) {
		int result[]=new int[commands.length];
	
		for(int i=0; i<commands.length; i++) {
			int cutArray[]=Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
			Arrays.sort(cutArray);
//
//			System.out.println(Arrays.toString(array));
//			System.out.println(Arrays.toString(cutArray));
			result[i]=cutArray[commands[i][2]-1];
		}
		return result;
		
	}

}
