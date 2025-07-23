package 불량사용자;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	
	List<String> collaboration=new ArrayList<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};

        int n=s.solution(user_id, banned_id);
        System.out.println(n);
	}
	
	public int solution(String user_id[], String banned_id[]) {
		
		String banned_ids[]=new String[banned_id.length] ;//해당하는 사람들 아이디
		for(int i=0; i<banned_id.length; i++) {
			banned_ids[i]=new String("");
		}
	
		//ban 패턴구하기
		String banned_pattern[]=new String[banned_id.length] ;
		for(int i=0; i< banned_id.length; i++) {
			String banStr=banned_id[i];
			banned_pattern[i]=banStr.replaceAll("\\*", ".");
			System.out.println(banned_pattern[i]);
		}
		
		
		for(int i=0; i< user_id.length; i++) {
			String user=user_id[i];
			for(int j=0; j<banned_pattern.length; j++) {
				String pattern=banned_pattern[j];
				if(user.matches(pattern)) {
					banned_ids[j]+="#"+user;
				}
			}
		}
		
		String[][] arrays=new String[banned_id.length][];
		
		
		for(int i=0; i< banned_ids.length; i++) {
	
		banned_ids[i]=banned_ids[i].replaceAll("^#", "");
		arrays[i]=banned_ids[i].split("#");
		}
		
		
	
//		for(int i=0; i< arrays.length; i++) {
//			System.out.println(Arrays.toString(arrays[i]));
//		}
		
		recursion(arrays,0,"");
		System.out.println("==============");
		for(int i=0; i<collaboration.size(); i++) {
			System.out.println(collaboration.get(i));
		}
		
		
		return collaboration.size();
	}
	
	public void recursion(String arrays[][],int deepth, String prefix) {
		
		//3차원일경우 deepth 가 0 , 1, 2 -> 3이되면 끝 0부터 시작하기 때문에
		if(deepth==arrays.length) {
			String str[]=prefix.split("#");
			Arrays.sort(str);
			String str2=Arrays.toString(str);

			
			if(!collaboration.contains(str2)) {

				collaboration.add(str2);
			}
			return;
		}
		
		for(int i=0; i<arrays[deepth].length; i++) {
			if(prefix.contains("#"+arrays[deepth][i]+"#"))continue;
			String newPrefix=prefix+"#"+arrays[deepth][i]+"#";
			recursion(arrays,deepth+1,newPrefix);
		}
	}

}
