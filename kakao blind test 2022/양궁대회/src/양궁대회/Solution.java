package 양궁대회;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	int[] bestArr=new int[11];
	int max=Integer.MIN_VALUE;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		Solution s=new Solution();
//		int answer[]=s.solution(5, new int[] {2,1,1,1,0,0,0,0,0,0,0});
//System.out.println(Arrays.toString(answer));
//	}
	
	 public int[] solution(int n, int[] info) {
		 
		 int count=0;
		   for(int i=0; i<n; i++) {
			   if(info[i]==1) {
				   count++;
			   }
		   }
		   if(count==n) return new int[] {-1};
		   
		
		 	
		 	dfs(new ArrayList<Integer>(),info,0,n);
		 	System.out.println(Arrays.toString(bestArr));
		 	return bestArr;
		 	
		 	
		 
	  }
	 
	 public int getScore(List<Integer> selectIndexList) {
		 int sum=0;
		 for(int i=0; i<selectIndexList.size(); i++) {
			 int score=10-selectIndexList.get(i);
			
			 sum+=score;
		 }
		 return sum;
	 }
	 
	 public int getScore(List<Integer> selectIndexList , int info[]) {
		 int sum=0;
		 for(int i=0; i<info.length; i++) {
			 if(info[i]!=0 && !selectIndexList.contains(i)) {
				 sum+=10-i;
			 }
		 }
		 
		 return sum;
		 
	 }
	 public int[] createArr(List<Integer>  selectIndexList,int info[], int n) {
		 int arr []=new int[info.length];
		 for(int i=0; i<info.length; i++) {
			 if(selectIndexList.contains(i)) {
				 arr[i]=info[i]+1;
			 }else {
				 arr[i]=0;
			 }
		 }
		 arr[info.length-1]+=n;
		 return arr;
		 
	 }
	 
	 public int[] isBetter(int a[],int b[]) {
		 for(int i=a.length-1; i>=0;i--) {
			 if(a[i] > b[i]) {
				 return a;
			 }else if(a[i] < b[i]) {
				 return b;
			 }
		 }
		 
		 return a;
	 }
	 
	 public void dfs(List<Integer> selectIndexList,int []info,int selectIndex,int n) {
		 
		
		 if(n==0 || selectIndex>=11) {
			 int score=getScore(selectIndexList);
			 int infoScore=getScore(selectIndexList,info);
			 int gap=score-infoScore;
			// System.out.print("infoScore : "+infoScore + " , score : "+score +" gap : "+gap+"  n : "+n+" " );
			 //System.out.println(selectIndexList.toString());
				
			 

			 if(gap==max) {
				 int tryBest[]=createArr(selectIndexList,info,n);
				 bestArr=isBetter(tryBest, bestArr);
				 //System.out.println("gap == max 같을 때 bestArr update : "+Arrays.toString(bestArr));
				 max=gap;	
			
			 }
			 else if(gap>max) {
				 
				// System.out.println(selectIndexList.toString()+"일 때 , GAP : "+gap );
				 bestArr=createArr(selectIndexList,info,n);
			//	 System.out.println("gap > max 같을 때 bestArr update : "+Arrays.toString(bestArr));
				 max=gap;	
				
			 }
			 return;
			 
			 
		 }
		 
		 
		 for(int i=0; i<2; i++) {
			 
			 //현재 자리수를 포기하냐 안하냐
			 // i가 0이라면 선택, i가 1이라면 포기.
			 if(i==0) {
				// System.out.println(selectIndex+"선택 고민중");
				 int selectValue=info[selectIndex];
				 //selectValue 남아있는 화살표가 작다면 이것은 선택하지 못한다.
				 if(selectValue >=n) {
					 //선택할 수 없다.
					 continue;
				 }else {

				//	 System.out.println(selectIndex+"선택 완료");
					 int newN=n-(selectValue+1);
					
					 List<Integer> newList=new ArrayList<Integer>(selectIndexList);
					 newList.add(selectIndex);
					 dfs(newList,info,selectIndex+1,newN);
				 }
			 }else {
				// System.out.println(selectIndex+"선택 안해!");
				 dfs(selectIndexList,info,selectIndex+1,n);
			 }
			 
		 }
		 
		 
		 
	 }

}
