package 신고결과받기_92334;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	Map<String,Integer> map=new HashMap<String, Integer>();

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"} , 2);
//	
//}

 public int[] solution(String[] id_list, String[] report, int k) {
	 Map<String,Member> memberMap=new HashMap<String, Solution.Member>();
	 
	 for(String id : id_list) {
		 map.put(id, 0);
		 Member m =new Member(id);
		 memberMap.put(id, m);
	 }
	 
	 for(String rep: report) {
		 String split[]=rep.split(" ");
		 
		 String a=split[0];
		 String b=split[1];
		 
		 memberMap.get(a).report(b);
	 }
	 Set<String> condition=new HashSet<String>();
	 
	 for(String id : id_list) {
		 
		 Set<String> sets=memberMap.get(id).reports;
		 for(String str : sets) {
			 map.merge(str, 1, (a,b)->a+b);
			 
			 if(map.get(str) >= k) {
				 condition.add(str);
			 }
		 }
		 
	 }
	 
	 int answer[]=new int[id_list.length];
	 int index=0;
	 for(String id : id_list) {
		 Set<String> sets =memberMap.get(id).reports;
		 sets.retainAll(condition);
		 answer[index++]=sets.size();
	 }
	 
	 System.out.println(Arrays.toString(answer));
	 
	 return answer;
	 
	 
 }
 
 class Member{
	 String name;
	 Set<String> reports;
	 
	 public Member(String name) {
		 this.name=name;
		 reports=new HashSet<String>();
	 }
	 
	 public void report(String name) {
		 reports.add(name);
	 }
 }
}
