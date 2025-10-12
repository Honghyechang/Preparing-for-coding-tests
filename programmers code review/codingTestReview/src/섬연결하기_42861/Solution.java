package 섬연결하기_42861;

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
	
		 //크루스칼 알고리즘
		 //모든 섬을 연결하면서 가중치를 최소화시키기
		 //가중치를 오름차순으로 정렬하여
		 //사이클이 형성
		 List<Info> infoList=new ArrayList<Solution.Info>();
		 for(int i=0; i<costs.length; i++) {
			 int eageNumber1=costs[i][0];
			 int eageNumber2=costs[i][1];
			 int weight=costs[i][2];
			 
			 infoList.add(new Info(eageNumber1,eageNumber2,weight));
		 }
		 
		 Collections.sort(infoList,(a,b)->a.weight-b.weight);
		 
		 List<Node> nodes=new ArrayList<Node>();
		 for(int i=0; i<n; i++) {
			 nodes.add(new Node());
		 }
		 
		 int answer=0;
		 for(Info info : infoList) {
			 Node nodeA=nodes.get(info.a);
			 Node nodeB=nodes.get(info.b);
			 
			 if(nodeA.merge(nodeB)) {
				 answer+=info.weight;
			 };
			 
			 
		 }
		 System.out.println(answer);
		 
		 
		 
		 return answer;
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
	 class Node{
		 Node parent;
		 int depth;
		 public Node() {
			 parent=null;
		 }
		 
		 public boolean isConnect(Node node) {
			return node.getRoot()==this.getRoot();
		 }
		 
		 public boolean merge(Node node) {
			 
			 if(isConnect(node)) {
				 return false;
			 }
			 
			 Node root1=this.getRoot();
			 Node root2=node.getRoot();
			
			 
			 if(root1.depth > root2.depth) {
				 root2.parent=root1;
			 }else if(root1.depth < root2.depth) {
				 root1.parent=root2;
			 }else {
				 root1.parent=root2;
				 root2.depth+=1;
			 }
			 
			 return true;
		 }
		 
		 public  Node getRoot()  {
			 if(this.parent==null) return this;
			 else {
				 return this.parent.getRoot();
			 }
			 
		 }
	 }
}
