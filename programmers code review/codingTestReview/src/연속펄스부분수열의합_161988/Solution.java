package 연속펄스부분수열의합_161988;

import java.util.Arrays;

public class Solution {
	
	int answerStart;
	int answerEnd;
	
	int start,end;
	long max=Integer.MIN_VALUE;

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new int[] {2, 3, -6, 1, 3, -1, 2, 4});
//	}

	
	   public long solution(int[] sequence) {
		   
		   //카데인 알고리즘 (Kadane's Algorithm)
		   //"연속 부분 수열의 최대 합"을 O(N)에 찾는 알고리즘
		   
		   
		   //누적값 vs 현재값 비교하기
		   //누적값 < 현재값 이어하기  -> 이어하는데 max보다 커지면 e업데이트
		   //누적값 > 현재값 현재값으로 새로 시작하기 -> s업데이트
		   
		   
		   int minusStart[]=Arrays.copyOf(sequence, sequence.length);
		  
		   int plusStart[]=Arrays.copyOf(sequence, sequence.length);
		   
		   for(int i=0; i<minusStart.length; i++) {
			   if(i%2==0) {
				   minusStart[i]=minusStart[i] * -1;
			   }else {
				   plusStart[i]=plusStart[i] *-1;
			   }
		   }
		   
//		   for(int n : minusStart) {
//			   System.out.print(n + " : ");
//		   }
//		   System.out.println();
//		   
//		   
//		   for(int n : plusStart) {
//			   System.out.print(n + " : ");
//		   }
//		   System.out.println();
		   
		   
		   long sum=0;
		   
		   for(int i=0; i<plusStart.length; i++) {
			   sum += plusStart[i];
			   if(sum < plusStart[i]) {
				   start=i;
				   end=i;
				   sum=plusStart[i];
			   }else {
				   end=i;
			   }
			   
			   if(max < sum) {
				   max=sum;
				   answerStart=start;
				   answerEnd=end;
			   }
		   }
		 
		 //  System.out.println("plusStart 까지의 결과 -> " + "max : "+max + " answerStart : "+answerStart  + " answerEnd : "+answerEnd);
			  
		   
		   
		   sum=0;
		   
		   for(int i=0; i<minusStart.length; i++) {
			   sum += minusStart[i];
			   if(sum < minusStart[i]) {
				   start=i;
				   end=i;
				   sum=minusStart[i];
			   }else {
				   end=i;
			   }
			   
			   if(max < sum) {
				   max=sum;
				   answerStart=start;
				   answerEnd=end;
			   }
		   }
		   //System.out.println("minusStart 까지의 결과 -> " + "max : "+max + " answerStart : "+answerStart  + " answerEnd : "+answerEnd);
			
		   
		   
		   
		   //getMax(plusStart,0,0);
		   //System.out.println("plusStart 까지의 결과 -> " + "max : "+max + " answerStart : "+answerStart  + " answerEnd : "+answerEnd);
		   
		   //getMax(minusStart,0,0);
		//   System.out.println("minusStart 까지의 결과 -> " + "max : "+max + " answerStart : "+answerStart  + " answerEnd : "+answerEnd);
		   
		   
		   return max;
	    }
	   
	   public void getMax(int arr[],int depth ,long sum) {
		   if(depth==arr.length) {
			   return;
		   }
		   
		   //현재 누적값과 나의 값을 비교하기
		   sum +=arr[depth];
		   if(sum < arr[depth]) {
			   //새로시작
			  start=depth;
			  end=depth;
			  sum=arr[depth];
		   }else {
			   //이어나가
			   end=depth;
		   }
		   
		   if(max < sum) {
			   max=sum;
			   answerStart=start;
			   answerEnd=end;
		   }
		   
		   getMax(arr,depth+1,sum);
		   
	   }
}
