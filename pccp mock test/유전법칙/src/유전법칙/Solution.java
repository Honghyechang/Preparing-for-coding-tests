package 유전법칙;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		s.solution(new int[][] {{3, 5},{3,8},{3,9},{4,26}});
//
//	}
	
	  public String[] solution(int[][] queries) {
		  	
//		   int wantGeneration=Integer.MIN_VALUE;
//		   for(int i=0; i<queries.length; i++) {
//			   int n=queries[i][0];
//			   if(wantGeneration<n) {
//				   wantGeneration=n;
//			   }
//		   }
//		   
//		   List<Generation> genList=new ArrayList<Solution.Generation>();
//		   for(int i=1; i<=wantGeneration; i++) {
//				  Generation g=new Generation(i);
//				  genList.add(g);
//			}
//		   
//		   genList.get(0).nodes.add("Rr");
//		   
//		   for(int i=1; i<wantGeneration; i++) {
//			   List<String> currentList=genList.get(i).nodes;
//			   List<String> beforeList=genList.get(i-1).nodes;
//			   
//			   for(String type : beforeList) {
//				   if(type.equals("RR")) {
//						  for(int j=0; j<4; j++) {
//							 currentList.add("RR");
//						  }
//					  
//					  }else if(type.equals("Rr")) {
//						  currentList.add("RR");
//						  currentList.add("Rr");
//						  currentList.add("Rr");
//						  currentList.add("rr");
//						
//					  }else if(type.equals("rr")) {
//						
//						  for(int j=0; j<4; j++) {
//								 currentList.add("rr");
//							  }
//					  }
//			   }
//			   
//		   }
		   
		   String []answerList=new String[queries.length];
		   for(int i=0; i<queries.length; i++) {
			   System.out.println(queries[i][0]+","+ queries[i][1]);
			   answerList[i]=getGene(queries[i][0], queries[i][1]);
			   System.out.println(answerList[i]);
			   
		   }
		   
		   
		   
		   
		   
//		   List<Generation> genList=new ArrayList<Solution.Generation>();
//		   
//		   bfs(wantGeneration,genList);
//		   
//		   String []answerList=new String[queries.length];
//		   for(int i=0; i<queries.length; i++) {
//			   int genration=queries[i][0];
//			   int target=queries[i][1];
//			   
//			   String targetStr=genList.get(genration-1).nodes.get(target-1).str;
//			   answerList[i]=targetStr;
//			   
//		   }
//		   
		   System.out.println(Arrays.toString(answerList));
		   
		   return answerList;
	 }
//	  
//	  public void bfs(int wantGeneration,List<Generation> genList) {
//		  
//		  for(int i=1; i<=wantGeneration; i++) {
//			  Generation g=new Generation(i);
//			  genList.add(g);
//			  //1세대를 원하면 1-1=0 genList.get(0) 을 구해서 거기에 있는 nodes에 접근한다.
//			  //2세대를 원하면 genList.get(1)에 접근하기!
//		  }
//		  
//		  
//		  Node rootNode=new Node(1,"Rr");
//		  genList.get(0).nodes.add(rootNode);
//		  Queue<Node> queue=new LinkedList<Node>();
//		  queue.add(rootNode);
//		  
//		  while(true) {
//			  Node node=queue.poll();
//			  int nextGeneration=node.generation+1;
//			  String type=node.str;
//			  
//			  if(nextGeneration>wantGeneration)break;
//			  
//			  if(type.equals("RR")) {
//				  
//				  for(int i=0; i<4; i++) {
//					  Node insertNode=new Node(nextGeneration,"RR");
//					  queue.add(insertNode);
//					  genList.get(nextGeneration-1).nodes.add(insertNode);
//				  }
//			  
//			  }else if(type.equals("Rr")) {
//				  Node insertNode1=new Node(nextGeneration,"RR");
//				  queue.add(insertNode1);
//				  genList.get(nextGeneration-1).nodes.add(insertNode1);
//				  
//				  Node insertNode2=new Node(nextGeneration,"Rr");				  
//				  queue.add(insertNode2);
//				  genList.get(nextGeneration-1).nodes.add(insertNode2);
//				  
//				  Node insertNode3=new Node(nextGeneration,"Rr");
//				  queue.add(insertNode3);
//				  genList.get(nextGeneration-1).nodes.add(insertNode3);
//				  
//				  Node insertNode4=new Node(nextGeneration,"rr");
//				  queue.add(insertNode4);
//				  genList.get(nextGeneration-1).nodes.add(insertNode4);
//				  
//			  }else if(type.equals("rr")) {
//				  for(int i=0; i<4; i++) {
//					  Node insertNode=new Node(nextGeneration,"rr");
//					  queue.add(insertNode);
//					  genList.get(nextGeneration-1).nodes.add(insertNode);
//				  }
//				  
//			  }
//			  
//		  }
//	  }
//	  
//	  class Generation{
//		  int generation;
//		  List<Node> nodes;
//		 
//		  public Generation(int generation) {
//			  this.generation=generation;
//			  nodes=new ArrayList<Solution.Node>();
//		  }
//		  
//	  }
//	  
//	  class Node{
//		  int generation;
//		  String str;
//		  
//		  public Node(int generation,String str) {
//			  this.generation=generation;
//			  this.str=str;
//		  }
//	  }
	  class Generation{
		  int generation;
		  List<String> nodes;
		 
		  public Generation(int generation) {
			  this.generation=generation;
			  nodes=new ArrayList<String>();
		  }
		  
	  }
	  
	  class Node{
		  int generation;
		  String str;
		  
		  public Node(int generation,String str) {
			  this.generation=generation;
			  this.str=str;
		  }
	  }

	  
	  
	  public String getGene(int n, int p) {
		  
		  if(n==1)return "RR";
		  //n번째 generation의
		  //n번째에서 p순서의 String을 찾고자한다.
		  
		  //현재 p가 몇번째 그룹에 속하는지를 알아야한다.
		  //한 그룹의 개수를 구해야한다.
		  int countByGenration=(int)Math.pow(4, n-1);
		  int groupByCount=(int)Math.pow(4, n-2);
		  
//		  System.out.println(countByGenration +" , "+groupByCount);
//		  System.out.println(groupByCount+" / "+p+ " -> "+groupByCount/p);
		  int pGroup=p/groupByCount;
		  int pGroupCount=p%groupByCount;
		  
		  int pGroupCountBySequence=pGroupCount%4;
		  //그룹에서 10번째라고하면 이것은  RR , Rr , Rr, rr이 계속반복될것이다. 
		  //4개의 규칙이 존재한다.
		  
		  System.out.println("p : "+p+" 는 pGroup : "+pGroup+" 에 속하고 pGroupCount : "+pGroupCount+" 그중 순에 있다.");
		  
		  if(pGroup==0) {
			  return "Rr";
		  }else if(pGroup==3) {
			  return "rr";
		  }else {
			  switch(pGroupCount%4) {
			  case 1: return "RR";
			  case 2:case 3: return "Rr";
			  case 0: return "rr";
			  }
		  }
		  return "";
	  }
}
