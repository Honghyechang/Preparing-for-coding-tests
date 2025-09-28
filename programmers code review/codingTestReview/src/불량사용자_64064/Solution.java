package 불량사용자_64064;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

	Set<String> set =new HashSet<String>();
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
//	String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//    String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
//
//    int n=s.solution(user_id, banned_id);
//    System.out.println(n);
//}

	public int solution(String user_id[], String banned_id[]) {
		
		
			String patterns[]=new String[banned_id.length];
			//알파벳과숫자
			String ablePattern="[\\d|a-z]";
			
			
			List<List<String>> banMatchWordList=new ArrayList<List<String>>();
			
			
			for(int i=0; i<banned_id.length; i++) {
				StringBuilder sb=new StringBuilder();
				String banned=banned_id[i];
				char chars[]=banned.toCharArray();
				for(int j=0; j<chars.length; j++) {
				char ch=chars[j];
					if(ch=='*') {
						sb.append(ablePattern);
					}else {
						sb.append(ch);
					}
				}
				
				patterns[i]=sb.toString();
			}
			
			
			for(int i=0; i<patterns.length; i++) {
				String pattern=patterns[i];
				List<String> matches=new ArrayList<String>();
				
				for(String id : user_id) {
					if(id.matches(pattern)) {
						matches.add(id);
					}
					
				}
				
				banMatchWordList.add(matches);
			}
			
			
			
			
		
		
			dfs(banMatchWordList,0,banMatchWordList.size(),new ArrayList<String>());

			System.out.println();
			return set.size();
		
	}
	
	public void dfs(List<List<String>> banMatchWordList , int index , int size , List<String> selectString) {
		
		if(index==size) {
			//앞뒤로 ## 넣기
			String word=selectString.stream()
						.map((str)->"#"+str+"#")
						.sorted()
						.collect(Collectors.joining());
			//System.out.println(word);
			set.add(word);
			return;
		}
		
		List<String> current=banMatchWordList.get(index);
		for(String str : current) {
			if(!selectString.contains(str)) {
				selectString.add(str);
				dfs(banMatchWordList,index+1,size,selectString);
				selectString.remove(str);
			}
		}
		
	}
}
