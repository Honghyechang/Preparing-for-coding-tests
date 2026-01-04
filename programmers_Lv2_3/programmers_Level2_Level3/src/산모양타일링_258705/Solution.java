package 산모양타일링_258705;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s=new Solution();
		s.solution(2,new int[] {0,1});
	}
	int answer=0;
	
	  public int solution(int n, int[] tops) {
		  //총 만들 삼각형 개수
		  
		  
		 List<TrieAngle> trieList=new ArrayList<Solution.TrieAngle>();
		 
		  
		  int index=0;
		  for(int i=0; i<n+(n+1); i++) {
			  TrieAngle t=new TrieAngle(i);
			  if(i!=n+n) {
				  t.add(i+1);
			  }
			  trieList.add(t);
			  index=i;
		  }
		  
		  index++;
		  for(int i=0; i<tops.length; i++) {
			  if(tops[i]==1) {
				  TrieAngle t=new TrieAngle(index);
				  int m=i*2+1;
				  TrieAngle trie=trieList.get(m);
				  trie.add(index);
				  
				  trieList.add(t);
				  index++;
			  }
		  }
		  
		  TrieAngle[] trieArr=trieList.stream()
				  					.toArray(TrieAngle[]::new);
		  
//		  for(TrieAngle t: trieArr) {
//			  System.out.println("인덱스 : "+t.index);
//			  System.out.println("knows : ");
//			  for(int i=0; i<t.knowsIndex.size();i++) {
//				  System.out.print(t.knowsIndex.get(i) + " ,");
//			  }
//			  System.out.println();
//		  }
//		  
		  int[] visited=new int[trieArr.length]; 
		  getAnswer(visited,trieArr,new ArrayList<Integer>(),false,0,1);
		  
		  
		  System.out.println(answer);
	        int answer = 0;
	        return answer;
	  }
	  
	  public boolean isAllvisited(boolean[]visited) {
		  for(boolean v:visited) {
			  if(!v)return false;
		  }
		  return true;
	  }
	  
	  public void getAnswer(int[] visited, TrieAngle[] trieArr,List<Integer> knows, boolean pack , int visiteCount , int visitNumber) {
		 
		  System.out.println("pack : "+pack + " number : "+visiteCount);
		  visited[visiteCount]=visitNumber;
		  knows=trieArr[visiteCount].knowsIndex;
		  
		  //모두 방문했으면 +1
		  if(visiteCount==trieArr.length) {
			  System.out.println("ssssssss");
			  answer++;
			  answer=answer%10007;
			  System.out.println(Arrays.toString(visited));
			  return;
		  }
		  
		  
		  //묶은것으로 넘기면 얘는 본인과 못묶는다.
		  //나랑 안묶게 넘기면 다음에서 묶을 수 있다.
		  for(int know: knows) {
			  if(visited[know]!=0)continue;
			  
			  if(pack) {	
				  getAnswer(visited,trieArr,knows,false,visiteCount+1,visitNumber+1);
			  }
			  else {
				  getAnswer(visited,trieArr,knows,false,visiteCount+1,visitNumber+1);
				  getAnswer(visited,trieArr,knows,true,visiteCount+1,visitNumber);
			  }
			 
		  }
		  
	  }
	  
	  
    
    
//밑에만 알면된다.
	  class TrieAngle{
		  int index;
		  List<Integer> knowsIndex;
		  public TrieAngle(int index) {
			  this.index=index;
			  knowsIndex=new ArrayList<Integer>();
		  }
		  
		  public void add(int t) {
			  knowsIndex.add(t);
		  }
	  }
}
