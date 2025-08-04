package 없는숫자더하기;

import java.util.HashMap;
import java.util.Map;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		int n=s.solution(new int[] {1,2,3,4,6,7,8,0});
//		System.out.println(n);
//
//	}

	public int solution(int numbers[]) {
		Map<Integer,Integer> map =new HashMap<Integer, Integer>();
		
		for(int i=0; i<=9; i++) {
			map.put(i, 1);
		}
		
		for(int i=0; i<numbers.length; i++) {
			int n=numbers[i];
			map.put(n,0);
		}
		int sum=0;
		for(int i=0; i<=9; i++) {
			if(map.get(i)!=0) {
				sum+=i;
			}
		}
		return sum;
	}
}
