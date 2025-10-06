package 사칙연산_1843;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
	
	Result map[][];
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		Solution s=new Solution();
		int n=s.solution(new String[] {"1","-","3","+","5","-","8"});
		System.out.println(n);
		
		
	}

	 public int solution(String arr[]) {
		 
		 map=new Result[arr.length+1][arr.length+1];
		Result result= dfs(arr,0,arr.length);
		//System.out.println("최대 : "+result.max);
		 return result.max;
	 }
	 
	 
	 //end는 포함하지 않는범위
	 public Result dfs(String arr[],int start,int end) {
		 //start , end를 연산자 기준으로 나눈다
		 if(start==end-1) {
			// System.out.println(start+"~"+end);
			 Result result=new Result(start, end);
			 result.setMax(Integer.parseInt(arr[start]));
			 result.setMin(Integer.parseInt(arr[start]));
			 return result;
		 }
		 if(map[start][end]!=null) {
			 return map[start][end];
		 }
		 
		 
		 int beforeStart=start;
		 int max=Integer.MIN_VALUE;
		 int min=Integer.MAX_VALUE;
		 for(int i=start+1; i<end; i=i+2) {
//			 System.out.println("left : "+ Arrays.toString(Arrays.copyOfRange(arr, beforeStart,i)));
//			 System.out.println("연산자 : "+arr[i]);
//			 System.out.println("right : "+ Arrays.toString(Arrays.copyOfRange(arr,i+1,end)));
//			 System.out.println();
//			 
			 
			 
			 Result left=dfs(arr,start,i);
			 Result right=dfs(arr,i+1,end);
			 
			 if(arr[i].equals("+")) {
				 max=Math.max(max,left.max +  right.max);
				 min=Math.min(min, left.min+right.min);
			 }else {

				 max=Math.max(max,left.max -  right.min);
				 min=Math.min(min, left.min-right.max);
			 }
			 
			 
		 }
		 
		 Result result=new Result(start, end);
		 result.setMax(max);
		 result.setMin(min);
		 map[start][end]=result;
		 
		 return result;
		 
	 }
	 
	 class Result{
		 int start;
		 int end;
		 int max;
		 int min;
		 public Result(int start,int end) {
			 this.start=start;
			 this.end=end;
		 }
		 public void setMax(int max) {
			 this.max=max;
		 }
		 

		 public void setMin(int min) {
			 this.min=min;
		 }
		 
		 @Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			 Result r=(Result)obj;
			return this.start==r.start && this.end==r.end;
		}
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return Objects.hash(start,end);
		}
		 
	 }

}
