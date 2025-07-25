package 메뉴리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
	
	Map<String,Integer> resultMap=new HashMap<String,Integer>();
	static List<String> result=new ArrayList<String>();
	List<String> collaborations=new ArrayList<String>();
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		String orders[]= {"ABCFG","AC","CDE","ACDE","BCFG","ACDEH"};
		int course[]= {2,3,4};
		String []arr=s.solution(orders,course);
		
    System.out.println(Arrays.toString(arr));
	}
	
	public String[] solution(String orders[],int course[]) {
		
		
		//문자열로 모든 조합구하기
		for(int i=0; i<course.length; i++) {
			for(int j=0; j<orders.length; j++) {
				//System.out.println("makeCollaboration  orders[j] = "+orders[j]+" i = "+i);
				makeCollaboration(orders[j],"",course[i]);
			}
			
		}
		
		for(int k=0; k<course.length; k++) {
			maxHashMap(course[k]);
		}
		String resultStr[]=result.toArray(new String[result.size()]);
		Arrays.sort(resultStr);
		return resultStr;
	}
	
	public void maxHashMap(int n) {
		
		//System.out.println(n+" : n 값");
		List<String> strs=new ArrayList<String>();
		
		Set<String> sets=resultMap.keySet();
		Iterator<String> iterators=sets.iterator();
		
		int max=Integer.MIN_VALUE;
		
		while(iterators.hasNext()) {
			String key=iterators.next();
			int value=resultMap.get(key);
			
			if(key.length()!=n)continue;
			
			if(value>max) {
				strs.clear();
				strs.add(key);
				max=value;
			}
			else if(value==max) {
				strs.add(key);
			}
		}
		
		for(int i=0; i<strs.size(); i++) {
			result.add(strs.get(i));
		}
		
	}
	
	public void makeCollaboration(String remaining,String make,int n) {
		//remaining 중에서 make를 만든다.
		if(make.length()==n) {
			//단어완성
			//System.out.println(make);
			make=make.chars()
				.boxed()
				.sorted((v1,v2)->{
					return v1-v2;
				})
				.map(i->(char)(int)(i)+"")
				.collect(Collectors.joining());

			//System.out.println(make);
			if(!collaborations.contains(make)) {
				collaborations.add(make);
			}else {
				if(resultMap.get(make)==null) {
					resultMap.put(make,1);
					//System.out.println(make+" : 1");
				}else {
					resultMap.put(make,resultMap.get(make)+1);
					//System.out.println(make+" : "+resultMap.get(make));
				}	
			}
		}
		
		for(int i=0; i<remaining.length(); i++)
		{
			String newMake=make+remaining.substring(i,i+1);
			String newRemaining=remaining.substring(i+1);
			makeCollaboration(newRemaining,newMake,n);
		}
	}

}
