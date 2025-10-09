package 길찾기게임_42892;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	
//	Solution s=new Solution();
//	s.solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});
//
//}

   public int[][] solution(int[][] nodeinfo){
	   
	   List<Node> nodes=new ArrayList<Solution.Node>();
	 
	   for(int i=0; i<nodeinfo.length; i++) {
		   Node node=new Node(nodeinfo[i][0],nodeinfo[i][1],i+1);
		   nodes.add(node);
	   }
	   
	   Collections.sort(nodes,(a,b)->b.level-a.level);
	   
//	   for(Node node : nodes) {
//		   System.out.println("level : "+node.level + "value : "+node.value + " number : "+node.nodeNumber);
//	   }
	   
	   
	   Node root=nodes.get(0);
	   for(int i=1; i<nodes.size(); i++) {
		   insert(root,nodes.get(i));
	   }
	   
	   
	   List<Integer> frontList=new ArrayList<Integer>();
	   List<Integer> rearList=new ArrayList<Integer>();
	   
	   front(root,frontList);
	   rear(root,rearList);
	   
	   int answer[][]=new int[2][];
	   answer[0]=frontList.stream()
			   			  .mapToInt(i->i.intValue())
			   			  .toArray();
	   

	   answer[1]=rearList.stream()
			   			  .mapToInt(i->i.intValue())
			   			  .toArray();
	   
	   
	   
	  // System.out.println(Arrays.toString(answer[0]));
	 //  System.out.println(Arrays.toString(answer[1]));
	   return answer;
   }
   
   public void front(Node root,List arrList) {
	   if(root==null)return;
	   
	   arrList.add(root.nodeNumber);
	   front(root.left,arrList);
	   front(root.right,arrList);
   }
   
   public void rear(Node root,List arrList) {
	   if(root==null)return;
	   
	   
	   rear(root.left,arrList);
	   rear(root.right,arrList);
	   arrList.add(root.nodeNumber);
   }
   
   public void insert(Node root, Node node) {
	   if(root.value > node.value) {
		   //왼쪽에서 다시 찾아
		   if(root.left!=null) {
			   insert(root.left,node);
		   }else {
			   root.left=node;
		   }
		  
	   }else {
		   //오른쪽에서 다시 찾아
		   if(root.right!=null) {
			   insert(root.right,node);
		   }else {
			   root.right=node;
		   }
	   }
	   
	   
   }
   

   class Node{
	   int level;//y를 의미
	   int value;//x를 의미
	   int nodeNumber;
	   
	   Node left=null;
	   Node right=null;
	   
	   public Node(int x,int y,int number) {
		   this.level=y;
		   this.value=x;
		   this.nodeNumber=number;
	   }
	   
	   public void setRight(Node node) {
		   this.right=node;
	   }

	   public void setLight(Node node) {
		   this.left=node;
	   }
	   
	   
   }
}
