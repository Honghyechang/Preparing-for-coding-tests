package 타켓넘버;

public class Solution {
	
	int answer=0;

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	Solution s=new Solution();
//	s.solution(new int[] {1,1,1,1,1}, 3);
//	}

	 public int solution(int[] numbers, int target) {
		
		 recursion(numbers,0,target,0);
		    System.out.println(answer);
	        return answer;
	 }
	 
	 public void recursion(int numbers[],int deepth,int target,int sum) {
		 
		 
		 if(deepth==numbers.length) {
			 
			 if(sum==target) {
				 answer++;
			 }
			 return;
		 }
		 
		 for(int i=0; i<2; i++) {
			 int current=numbers[deepth];
			 if(i==0) {
				 int newSum=sum+current;
				 recursion(numbers,deepth+1,target, newSum);
			 }else {

				 int newSum=sum+ (-1*current);
				 recursion(numbers,deepth+1,target, newSum);
			 }
		 }
	 }
}
