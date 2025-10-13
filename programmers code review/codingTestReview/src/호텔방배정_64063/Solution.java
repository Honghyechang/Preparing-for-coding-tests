package 호텔방배정_64063;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//	Solution s=new Solution();
//	s.solution(10, new long[] {1,3,4,1,3,1});
//}


	


  public long[] solution(long k, long[] room_number) {
	  
	  //현재 방
	  Map<Long,Long> maps=new HashMap<Long, Long>();
	  
	  long answer[]=new long[room_number.length];
	  for(int i=0; i<room_number.length; i++) {
		  long key=room_number[i];
		  if(!maps.containsKey(key)) {
			  //바로 배정해주기
			  answer[i]=key;
			  maps.put(key, key+1);
		  }else {
			  //만약 존재하면
			  
			  Long m=getRoot(maps,key);
			  answer[i]=m;
			  maps.put(m,m+1);
		  }
		  
		  
	  }
	  
	//  System.out.println(Arrays.toString(answer));
	  
	  return answer;
  }

  public Long getRoot(Map<Long,Long> maps, Long n) {
	  if(!maps.containsKey(n)) {
		  return n;
	  }
	  Long value=maps.get(n);
	  Long root=getRoot(maps,value);
	  maps.put(n, root);//업데이트
	  return maps.get(n);
  }
  
	
}
