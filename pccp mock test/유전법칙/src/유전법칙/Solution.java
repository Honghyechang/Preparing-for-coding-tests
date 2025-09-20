package 유전법칙;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		s.solution(new int[][] {{3, 5},{3,8},{3,4},{4,26}});

	}
	
	  public String[] solution(int[][] queries) {
		  	

		   
		   String []answerList=new String[queries.length];
		   for(int i=0; i<queries.length; i++) {
			   System.out.println(queries[i][0]+","+ queries[i][1]);
			   answerList[i]=getGene(queries[i][0], queries[i][1]-1);
			   System.out.println(answerList[i]);
			   
		   }
		   
		   	   
		   System.out.println(Arrays.toString(answerList));
		   
		   return answerList;
	 }

	  
	  public String getGene(int n, int p) {	  
		  if(n==1)return "Rr";
		  //n번째 generation의
		  //n번째에서 p순서의 String을 찾고자한다.
		  
		  //현재 p가 몇번째 그룹에 속하는지를 알아야한다.
		  //한 그룹의 개수를 구해야한다.
		  int countByGenration=(int)Math.pow(4, n-1);//총 노드개수
		  int groupByCount=(int)Math.pow(4, n-2);//한 그룹의 노드개수
		  
		  System.out.println("현재 genration : "+n+" 은 총 "+countByGenration+"노드로 이뤄져있고, 총 4개의 그룹으로 나눌 때 1그룹에 "+groupByCount+" 개의 노드로 구성되어있다.");
		 
		  
		  int pGroup=p/groupByCount; 
		  int pGroupCount=p%groupByCount;
		 
		  System.out.println(p+"는 "+pGroup+"에 속하고, 그룹에 "+pGroupCount+"번째에 있다");
		  
		  
		  if(pGroup==0) {
			  return "RR";
		  }else if(pGroup==3) {
			  return "rr";
		  }
		  return getGene(n-1,pGroupCount);
	  }
}
