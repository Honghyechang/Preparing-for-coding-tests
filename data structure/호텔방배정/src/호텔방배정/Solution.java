package 호텔방배정;

import java.util.HashMap;
import java.util.Map;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(10, new long[] {1,3,4,1,3,1});
//	}
//	
	
	  public long[] solution(long k, long[] room_number) {
		  
		   Map<Long,Long> map=new HashMap<Long, Long>();
		   long[] answer=new long[room_number.length];
		   
		   
		   for(int i=0; i<room_number.length; i++) {
			   answer[i]=findRoom(map, room_number[i]);
		   }
		   
//		   
//		   System.out.println(Arrays.toString(answer));
	        return answer;
	  }
	
	  public long findRoom( Map<Long,Long> map , long room) {
		  if(!map.containsKey(room)) {
			  //배정이 안됬다면
			  //배정을 시켜주고 다음 방부터 찾아~
			  map.put(room, room+1);
			  return room;
		  }
		  long n=map.get(room);
		  long select=findRoom(map, n); //결국 select가 선택된 방
		  map.put(room, select);
		  return select;
		  
	  }
	  
	  
	//답은 맞지만 효율성에서 실패
//	 public long[] solution(long k, long[] room_number) {
//		 
//		 Map<Long,Boolean> roomMap=new HashMap<Long,Boolean>();
//		 for(long i=1; i<=k; i++) {
//			 roomMap.put(i, false);
//		 }
//		 List<Long> list=new ArrayList<Long>();
//		 
//		 for(long i=0; i<room_number.length; i++) {
//			 long wantNumber=room_number[(int)i];
//			 boolean check=roomMap.get(wantNumber);
//			 
//			 if(!check) {
//				 roomMap.put(wantNumber, true);
//				 list.add(wantNumber);
//			 }else {
//				 long next=wantNumber+1;
//				 
//				 while(next<=k) {
//					 boolean ch=roomMap.get(next);
//					 if(ch) {
//						 next++;
//					 }else {
//						 roomMap.put(next, true);
//						 list.add(next);
//						 break;
//					 }
//				 }
//			 }
//		 }
//		 
//		// System.out.println(list.toString());
//		 long [] answers=list.stream()
//				 			 .mapToLong(Long::longValue)
//				 			 .toArray();
//		 
//		 
////	       System.out.println(Arrays.toString(answers));
//	        return answers;
//	  }

}
