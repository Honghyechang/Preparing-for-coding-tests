package 신고결과받기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"} , 2);
//		
//	}
	
	 public int[] solution(String[] id_list, String[] report, int k) {
		 
		 Set<String> dupRemoveSet=new HashSet<String>();
		 int[] answer = new int[id_list.length];
		 
		 for(int i=0; i<report.length; i++) {
			 dupRemoveSet.add(report[i]);
		 }
		 
		 Map<String,List<String>> map=new HashMap<>();
		 
		 Iterator<String> iterator=dupRemoveSet.iterator();
		 while(iterator.hasNext()) {
			 String key=iterator.next();
			 String[] keyArr=key.split(" ");
			 String user=keyArr[0].trim();
			 String target=keyArr[1].trim();
			 
			// System.out.println(user+ " -> "+target);
			 if(map.containsKey(target)) {
				 map.get(target).add(user);
			 }
			 else {
				 List<String> newList=new ArrayList<String>();
				 newList.add(user);
				 map.put(target, newList);
			 }
		 }
		 //key로는 신고당한사람->value 그 사람은 신고한사람들
		 
		 Map<String,Integer> answerMap=new HashMap<String, Integer>();
		 //키 신고한사람 value는 알람받은 횟수
		 Set<String> mapSets=map.keySet();
		 Iterator<String> mapIterator=mapSets.iterator();
		 
		 while(mapIterator.hasNext()) {
			 String key=mapIterator.next();
			 List<String> value=map.get(key);
			 
			 if(value.size()<k)continue;
			 
			 for(int i=0; i<value.size(); i++) {
				 String user=value.get(i);
				 if(answerMap.containsKey(user)) {
					 answerMap.put(user,answerMap.get(user)+1);
				 }else {
					 answerMap.put(user, 1);
				 }
			 }
		 }
		 
		 for(int i=0; i<id_list.length; i++) {
			 String user=id_list[i];
			 if(answerMap.containsKey(user)) {
				 answer[i]=answerMap.get(user);
			 }else {
				 answer[i]=0;
			 }
		 }
		 
		 //System.out.println(Arrays.toString(answer));
	        
	        return answer;
	 }

}
