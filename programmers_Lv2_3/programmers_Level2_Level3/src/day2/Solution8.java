package day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution8 {
	
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution8 s=new Solution8();
//	String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//    String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
//
//    int n=s.solution(user_id, banned_id);
//    System.out.println(n);
//		//System.out.println("*ss".replaceAll("\\*", "."));
//}

	public int solution(String user_id[], String banned_id[]) {

		//ban에 해당하는 아이디 List 다 구하고,
		//모든 조합 구해서 정렬 시키고 set에 넣은다음 개수 구하기
	
		List<List<String>> banedList=new ArrayList<List<String>>();
		for(int i=0; i<banned_id.length; i++) {
			String ban=banned_id[i];
			String banPattern=ban.replaceAll("\\*", ".");
			List<String> list=possible(banPattern,user_id);
			
			banedList.add(list);
		}
		
		//리스트들의 모든 조합
		collaborationList(banedList,0,new ArrayList<String>());
		
		System.out.println(sets.size());
		return sets.size();
		
	}
	
	Set<String> sets=new HashSet<String>();
	
	public void collaborationList(List<List<String>> lists, int index, List<String> selectList) {
		if(index==lists.size()) {
			
			
			
			String result=selectList.stream()
				  .map(i->"#"+i+"#")
				  .sorted()
				  .collect(Collectors.joining());
			
			//System.out.println(result);
			sets.add(result);
		
			return;
			
		}
		
		
		List<String> list=lists.get(index);
		for(int i=0; i<list.size(); i++) {
			String get=list.get(i);
			if(selectList.contains(get))continue;
			selectList.add(get);
			collaborationList(lists,index+1,selectList);
			selectList.remove(get);
		}
		
		
	}
	
	public List<String> possible(String banPattern, String user_id[]){
		List<String> list=new ArrayList<String>();
		//System.out.println(banPattern);
		for(String used : user_id) {
			if(used.matches(banPattern)) {
			//	System.out.println(used);
				list.add(used);
			}
		}
		return list;
	}

}
