package 섬연결하기_2_42861;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution {
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//	Solution s=new Solution();
//	int n=s.solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
//	System.out.println(n);
//}

	 public int solution(int n, int[][] costs) {

		 //처음에 본인으로 초기화를 시켜놓는다.
		 int parent[]=new int[n];
		 for(int i=0; i<parent.length; i++) {
			 parent[i]=i;
		 }
		 
		 List<Info> infoList=new ArrayList<Solution.Info>();
		 for(int i=0; i<costs.length; i++) {
			 int eageNumber1=costs[i][0];
			 int eageNumber2=costs[i][1];
			 int weight=costs[i][2];
			 
			 infoList.add(new Info(eageNumber1,eageNumber2,weight));
		 }
		 
		 Collections.sort(infoList,(a,b)->a.weight-b.weight);
		 
		 int answer=0;
		 for(int i=0; i<infoList.size(); i++) {
			 int a=infoList.get(i).a ;
			 int b=infoList.get(i).b ;
			 int w=infoList.get(i).weight;
			 
			 
			 if(union(parent, a, b)) {
				 answer+=w;
			 }
		 }
		 System.out.println(answer);
		 return answer;
		 
		 
	 }
	 
	 public boolean union(int parent[],int a, int b) {
		 int rootA=getRoot(parent, a);
		 int rootB=getRoot(parent, b);
		 if(rootA==rootB) {
			 return false;
		 }
		 
		 parent[rootA]=rootB;
		 return true;
		 
	 }
	 public int getRoot(int parent[],int n) {
		 if(parent[n]==n) return n;
		 parent[n]=getRoot(parent,parent[n]);//경로 압축
		 return parent[n];
	 }
	 class Info{
		 int a;
		 int b;
		 int weight;
		 
		 public Info(int a,int b , int weight) {
			 this.a=a;
			 this.b=b;
			 this.weight=weight;
		 }
		 
	 }
}
