package 신입사원교육;

import java.util.Arrays;

public class Solution {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new int[] {10, 3, 7, 2}, 2);
//	}
	
	public int solution(int[] ability, int number) {
		int answer=dfs(ability,number);
        return answer;
    }

	
	int dfs(int[] ability, int n) {
		
		int pick=n*2;
		Arrays.sort(ability);
		int pickArr[]=Arrays.copyOf(ability, pick);
		
		
		
		for(int i=0; i<n; i++) {
//			ability=Arrays.stream(ability)
//			      .sorted()
//			      .toArray();
			
			Arrays.sort(pickArr);
			int a=pickArr[0];
			int b=pickArr[1];
			pickArr[0]=a+b;
			pickArr[1]=a+b;
		}
		
		for(int i=0; i<pickArr.length; i++) {
			ability[i]=pickArr[i];
		}
		
		int sum=Arrays.stream(ability)
			      .sum();
		
		System.out.println(sum);
		return sum;
	}
}
