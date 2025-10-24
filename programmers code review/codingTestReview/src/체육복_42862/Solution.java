package 체육복_42862;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	
	int max=Integer.MIN_VALUE;

//		public static void main(String[] args) {
//			Solution s=new Solution();
//			int n=s.solution(5,new int[] {2,4}, new int[] {1,3,5});
//	System.out.println(n);
//		}
		
		 public int solution(int n, int[] lost, int[] reserve) {
			 //여벌이 있는 사람
			 List<Integer> lostList=Arrays.stream(lost).map(i->i-1).boxed().collect(Collectors.toList());
			 List<Integer> reserveList=Arrays.stream(reserve).map(i->i-1).boxed().collect(Collectors.toList());
			 
			
			 
			 //여벌있는 학생에서 , 잃어버린 학생 없애주고
			 //동시에 잃어버린 학생또한 없애준다.
			 List<Integer> removeList=new ArrayList<Integer>();
			 for(int m : reserveList) {
				 for(int k : lostList) {
					 
					 if(m==k) {
						 removeList.add(m);
					 }
					 
				 }
			 }
			 lostList.removeAll(removeList);
			 reserveList.removeAll(removeList);
			 
			 
			 maxRecursion(lostList,reserveList,new boolean[n],0,n);
			 System.out.println(max);
			 return max;
		 }
		 
		 public void maxRecursion(List<Integer> lostList, List<Integer> reserveList , boolean visited[],int depth, int n) {
			 if(depth==n) {
				 //visited의 true 개수 리턴
				 int count=0;
				 for(boolean visit : visited) {
					 if(visit) {
						 count++;
					 }
				 }
				 if(max<count) {
					 max=count;
					
				 }
				// System.out.println("max : "+max+" update");
				 return;
			 }
			 
			 //현재 depth가 잃어버린 학생이니?
			 if(!lostList.contains(depth)) {
				 visited[depth]=true;
				 maxRecursion(lostList,reserveList,visited,depth+1,n);
			 }else {
				 int before=depth-1;
				 int after=depth+1;
				 
				//둘다 포함되어있지 않은경우
				 if( !(before >=0 && reserveList.contains(before))  &&!(after <= n-1 && reserveList.contains(after))) {
					 visited[depth]=false;
					 maxRecursion(lostList,reserveList,visited,depth+1,n);
				 } else {
					 
					 if(before >=0 && reserveList.contains(before)) {
						 //전에한테 빌리기
						 reserveList.remove(Integer.valueOf(before));
						 visited[depth]=true;
						 maxRecursion(lostList,reserveList,visited,depth+1,n);
						 
						 //다시 돌려놓기
						 reserveList.add(before);
						 visited[depth]=false;
						 
					 }
					 
					 if(after <= n-1 && reserveList.contains(after)) {
						 //전에한테 빌리기
						 reserveList.remove(Integer.valueOf(after));
						 visited[depth]=true;
						 maxRecursion(lostList,reserveList,visited,depth+1,n);
						 
						 //다시 돌려놓기
						 reserveList.add(after);
						 visited[depth]=false;
						 
					 }
					 
				 }
				
				 
				
			 }
			 
		 }
}
