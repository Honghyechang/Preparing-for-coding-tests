package 양과늑대;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<Node> nodes;
	int max=Integer.MIN_VALUE;
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new int[] {0,0,1,1,1,0,1,0,1,0,1,1}, new int[][] {
//			{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}});
//		
//		
//	}
	
	 public int solution(int[] info, int[][] edges) {
		 nodes=new ArrayList<Solution.Node>();
		 for(int i=0; i<info.length; i++) {
			 Node node=new Node(i,info[i]==0?true : false);
			 nodes.add(node);
		 }
		 
		 for(int i=0; i<edges.length; i++) {
			 int n=edges[i][0];
			 int m=edges[i][1];
			 Node nNode=nodes.get(n);
			 Node mNode=nodes.get(m);
			 //nNode가! mNode를 알고 있다.
			 nNode.addChild(mNode);
		 }
		 
		 List<Integer> visited=new ArrayList<Integer>();
		 visited.add(0);
		 
		 dfs(visited,1,0);
		 
		 System.out.println(max);
		 
	     return max;
	     
	 }
	 
	 public void dfs(List<Integer> visited, int sheepCount, int wolfCount) {
		 
		 if(max < sheepCount) {
			 max=sheepCount;
			// System.out.println(max+"업데이트");
			
		 }
		 
		 
		// visited.stream().forEach(System.out::println);
		 
		 List<Node> visibleList = visibleNode(visited);
		 
		
		 
		 for(Node n : visibleList) {
			 int sheep=sheepCount;
			 int wolf=wolfCount;
			 if(n.sheep) {
				 sheep++;
			 }else {
				 wolf++;
			 }
			 if(sheep>wolf) {
				 List<Integer> newVisited=new ArrayList<Integer>(visited);
				 newVisited.add(n.number);
				 dfs(newVisited,sheep,wolf);
			 }
		 }
		 
	 }
	 
	 public List<Node> visibleNode(List<Integer> visited){
		 
		 List<Node> visibleList=new ArrayList<Node>();
		 
		 for(int visit : visited) {
			 for(Node n : nodes.get(visit).childrenNodes) {
				 if(!visited.contains(n.number)) {
					 visibleList.add(n);
				 }
			 }
		 }

//		 for(Node n : visibleList) {
//			 System.out.print(n.number+" , ");
//		 }
//		 System.out.println();
		 return visibleList;
			 
		 
	 }
	 
	 
	 
	 class Node{
		 int number;
		 boolean sheep;
		 List<Node> childrenNodes=new ArrayList<Solution.Node>();
		 public Node(int number,boolean sheep) {
			 this.number=number;
			 this.sheep=sheep;
		 }
		 
		 public void addChild(Node node) {
			 childrenNodes.add(node);
		 }
	 }

}
