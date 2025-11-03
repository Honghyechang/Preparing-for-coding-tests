package 유전법칙_121685;

import java.util.Arrays;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
//	s.solution(new int[][] {{3, 5},{3,8},{3,4},{4,26}});
//
//}

  public String[] solution(int[][] queries) {
	  String answer[]=new String[queries.length];
	  for(int i=0; i<queries.length; i++) {
		  answer[i]=get(queries[i][0],queries[i][1]-1);
	  }
//System.out.println(Arrays.toString(answer));
	  return answer;
	  
  }
  public String get(int generation, int sequence) {
	  
	  if(generation==1) {
		  return "Rr";
	  }
	  //한그룹의 개수
	  int groupMeberCount=(int)Math.pow(4, generation-2);
	  
	  //현재 sequence가 어느 그룹에 몇번째에 있는지
	  int group=sequence/groupMeberCount;
	  int groupSequence=sequence%groupMeberCount;
	  
	  if(group==0) {
		  return "RR";
	  }else if(group==3) {
		  return "rr";
	  }else {
		  return get(generation-1,groupSequence);
	  }
			  
	  
  }
}
