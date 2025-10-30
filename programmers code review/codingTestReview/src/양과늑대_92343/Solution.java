package 양과늑대_92343;

import java.util.ArrayList;
import java.util.List;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//	Solution s=new Solution();
//	s.solution(new int[] {0,0,1,1,1,0,1,0,1,0,1,1}, new int[][] {
//		{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}});
//	
//	
//}

Node[] nodes;
 public int solution(int[] info, int[][] edges) {
	 //핵심
	 //이동 가능한 노드 모두 구하기
	 //각 노드를 접근해보는데, 가능하다면 접근하기  동시에 접근함으로써 또 접근가능한 리스트를 늘릴 수 있다.
	 //계속해서 누적해나가면서 업데이트하기
	 
	 nodes=new Node[info.length];
	 for(int i=0; i<info.length; i++) {
		 nodes[i]=new Node(i,info[i]);
	 }
	 
	 for(int i=0; i<edges.length; i++) {
		 int nodeNumber=edges[i][0];
		 int targetNumber=edges[i][1];
		 
		 nodes[nodeNumber].addKnow(nodes[targetNumber]);
	 }
	 Node node=nodes[0];
	 List<Node> moveable=new ArrayList<Solution.Node>();
	 seekRoute(node,moveable,1,0);
	 
	 System.out.println(max);
	 return max;
	 
	 
	 
 }
 int max=1;
 public void seekRoute(Node node,List<Node> moveable,int sheepSum,int wolfSum) {
	 
	 //이 경우에만 이동이 가능하다.
	 if(max<sheepSum) {
		 max=sheepSum;
	 }
	 
	 //node로 갈 수 있는 것 업데이트하기 이러면 외부의 moveable 을 내부에서 수정하므로 문제가 발생한다.
//	 moveable.remove(node);
//	 for(Node n : node.knows) {
//		 moveable.add(n);
//	 }
	 
	 List<Node> updateMoveableList=new ArrayList<Solution.Node>(moveable);
	 updateMoveableList.remove(node);
	 updateMoveableList.addAll(node.knows);
	
	 
	 for(Node move : updateMoveableList) {
		 
		 //이것이 이동이 가능한지
		 int updateSheepSum=sheepSum;
		 int updateWolfSum=wolfSum;
		 if(move.isSheep) {
			 updateSheepSum++;
		 }else {
			 updateWolfSum++;
		 }
		 if(updateSheepSum>updateWolfSum) {
			
			 
			 seekRoute(move,updateMoveableList,updateSheepSum,updateWolfSum);
			 
		 }
		 
	 }
	
	 
	 
 }
 
 class Node{
	 int indexNumber;
	 boolean isSheep;
	 List<Node> knows;
	 
	 public Node(int intdexNumber,int sheep) {
		 this.indexNumber=intdexNumber;
		 if(sheep==0) {
			 this.isSheep=true;
		 }else {
			 this.isSheep=false;
		 }
		 knows=new ArrayList<Solution.Node>();
	 }
	 
	 public void addKnow(Node node) {
		 this.knows.add(node);
	 }
 }
}
