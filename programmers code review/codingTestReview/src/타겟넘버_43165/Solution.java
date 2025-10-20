package 타겟넘버_43165;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	Map<String,Integer> map=new HashMap<String, Integer>();

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//Solution s=new Solution();
//s.solution(new int[] {1,1,1,1,1}, 3);
//}

 public int solution(int[] numbers, int target) {
	
	 int n=recursion(numbers, 0, 0, target);
	 System.out.println(n);
	 return n;
 }
 //~때가지의 누적합
 // 3인덱스에서의 지금까지의 합이 30 이라면 3,30 이라는 이름으로 나올 수 있는 조합정하기
 
 public int recursion(int number[],int sum,int depth,int target) {
	 
	 if(map.containsKey(sum+","+depth)) {
		 return map.get(sum+","+depth);
	 }
	 
	 if(depth==number.length) {
		 if(sum==target) {
			 return 1;
		 }
		 return 0;
	 }
	 int count=0;
	 
	 count+=recursion(number, sum + number[depth], depth+1, target);
	 count+=recursion(number, sum - number[depth], depth+1, target);
	 map.put(sum+","+depth, count);
	 
	 
	 return count;
	 
 }
 
 
}
