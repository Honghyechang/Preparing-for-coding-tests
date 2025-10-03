package 순위검색_72412;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	
	Map<String,List<Integer>> maps=new HashMap<String,List<Integer>>();

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	String infos[]=new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
//	String query[]=new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
//	
//	Solution s=new Solution();
//	int [] result=s.solution(infos, query);
//	System.out.println(Arrays.toString(result));
//
//	}
	
	public int[] solution(String [] info,String [] query) {
		int answer[]=new int[query.length];
		
		for(int i=0; i<info.length; i++) {
			String infoString=info[i];
			String splits[]=infoString.split(" ");
			int score=Integer.parseInt(splits[4]);
			splits=Arrays.copyOfRange(splits, 0, 4);
			
			
			
			//System.out.println(Arrays.toString(splits) +" ,score : "+score);
			dfs(splits,new ArrayList<Integer>(),0,score);
			
		}
		
		for(String key : maps.keySet()) {
			List list=maps.get(key);
			Collections.sort(list);
		}
		
		
		for(int i=0; i<query.length; i++) {
			String queryString=query[i];
			int score=Integer.parseInt(queryString.replaceAll("[^\\d+]", ""));
			queryString=queryString.replaceAll("\\d+|and|\\s", "");
			//System.out.println("score : "+score+" , "+queryString);
			int count=binarySearch(queryString,score);
			answer[i]=count;
		}
	//	System.out.println(Arrays.toString(answer));
		return answer;
		
	}

	public int binarySearch(String query,int score) {
		if(!maps.containsKey(query)) {
			return 0;
		}
		List<Integer> list=maps.get(query);
		//1,2,4,5
		//3이상이면서 가장 작은 인덱스 찾기
		//e를 줄이면서 너 조건에 맞아? 맞다면 줄이기
//		int arr[]=list.stream()
//					  .mapToInt(i->i.intValue())
//					  .toArray();
		
		//System.out.println("==========="+Arrays.toString(arr)+"==============");
		
		//e가 작아지는것
		int s=0;
		int e=list.size();
		while(s<e) {
			int mid=(s+e)/2;
			if(score<=list.get(mid)) {
				e=mid;
			}else {
				s=mid+1;
			}
		}
		
	//	System.out.println("인덱스 s : "+s +" , 값 : "+arr[s]+" 이며, 현재 score : "+score+"와 가장 가까움");
		
		//e는 가장 가까운 인덱스
		int count=list.size()-s;
		return count;
		
	}
	public void dfs(String splits[],List<Integer> selectIndex,int start,int score) {
		
		if(selectIndex.size()>=0) {
			StringBuilder sb=new StringBuilder();
			for(int i=0; i<splits.length; i++) {
				String sp=splits[i];
				if(selectIndex.contains(i)) {
					sb.append("-");
				}else {
					sb.append(sp);
				}
			}
			
		//	System.out.println(sb.toString());
			String sbString=sb.toString();
			if(maps.containsKey(sbString)) {
			maps.get(sbString).add(score);
			}else {
				List<Integer> list=new ArrayList<Integer>();
				list.add(score);
				maps.put(sbString,list);
			}
			
			if(selectIndex.size()==4)return;
		}
		
		for(int i=start; i<splits.length; i++) {
			
			selectIndex.add(i);
			dfs(splits,selectIndex,i+1,score);
			selectIndex.remove(Integer.valueOf(i));
		}
		
	}
}
