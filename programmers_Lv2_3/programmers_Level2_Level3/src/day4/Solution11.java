package day4;

import java.util.Arrays;

public class Solution11 {
	
	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		Solution11 s=new Solution11();
		int n=s.solution(new String[] {"1","-","3","+","5","-","8"});
		System.out.println(n);
	}

	 public int solution(String arr[]) {
		 for(int maxarr[]: maxmemo) {
			 Arrays.fill(maxarr, -1);
		 }
		 
		 for(int minarr[]: minmemo) {
			 Arrays.fill(minarr, -1);
		 }
		 
		 return getMax(0,arr.length,arr);
	 }
	 int maxmemo[][]=new int[202][202];
	 int minmemo[][]=new int[202][202];
	 
	 public int getMax(int start, int end, String arr[]) {
		 if(end-start==1) {
			 //숫자를 리턴
			 return Integer.parseInt(arr[start]);
		 }
		 
		 
		 if(maxmemo[start][end]!=-1) {
			 return maxmemo[start][end];
		 }
		 
		 
		 
		 int max=Integer.MIN_VALUE;
		 //왼쪽 , 연산 , 오른쪽으로 분리를 시키기
		 for(int i=start+1; i<end; i=i+2) {
			 //start의 범위를 다시 start ~ i
			 //왼쪽은
			 int left=getMax(start,i,arr);
			 //오른쪽은
			 int result=0;
			 
			 //연산자
			 String op=arr[i];
			 if(op.equals("+")) {
				 //둘다 최대
				 int right=getMax(i+1,end,arr);
				 result=left+right;
			 }else {
				 //오른쪽은 최소
				 int right=getMin(i+1,end,arr);
				 result=left-right;
			 }
			 
			 if(result>max) {
				 max=result;
			 }
			 
		 }
		 
		 maxmemo[start][end]=max;
		 return max;
	 }
	 
	 public int getMin(int start, int end, String arr[]) {
		 if(end-start==1) {
			 //숫자를 리턴
			 return Integer.parseInt(arr[start]);
		 }
		 
		 if(minmemo[start][end]!=-1) {
			 return minmemo[start][end];
		 }
		 
		 
		 int min=Integer.MAX_VALUE;
		 
		 //왼쪽 , 연산 , 오른쪽으로 분리를 시키기
		 for(int i=start+1; i<end; i=i+2) {
			 //start의 범위를 다시 start ~ i
			 //왼쪽은
			 int left=getMin(start,i,arr);
			 int result=0;
			 //오른쪽은
			 
			 //연산자
			 String op=arr[i];
			 if(op.equals("+")) {
				 //둘다 최대
				 int right=getMin(i+1,end,arr);
				 result=left+right;
				 
			 }else {
				 //오른쪽은 최소
				 int right=getMax(i+1,end,arr);
				 result=left-right;
			 }
			 
			 if(result<min) {
				 min=result;
			 }
		 }
		 minmemo[start][end]=min;
		 return min;
	 }


}
