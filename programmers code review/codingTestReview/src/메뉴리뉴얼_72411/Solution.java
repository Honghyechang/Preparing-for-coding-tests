package 메뉴리뉴얼_72411;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	Map<String,Integer> map =new HashMap<String, Integer>();
	Map<Integer,List<String>> wantedSize=new HashMap<Integer, List<String>>();
//		public static void main(String[] args) {
//			// TODO Auto-generated method stub
//			Solution s=new Solution();
//			String orders[]= {"ABCFG","AC","CDE","ACDE","BCFG","ACDEH"};
//			int course[]= {2,3,4};
//			String []arr=s.solution(orders,course);
//			
//		System.out.println(Arrays.toString(arr));
//		}
//		
		public String[] solution(String orders[],int course[]) {
			for(int i=0; i<course.length; i++) {
				wantedSize.put(course[i],new ArrayList<String>());
		}
			
			
		//2개조합,3개조합,4조합
			for(int i=0; i<orders.length; i++)
			{
				String order=orders[i];
			//	System.out.println(order+"조합");
				dfs(order.toCharArray(),new char[order.length()],0,0);
				
			}
			
			
			for(String key : map.keySet()) {
				int value=map.get(key);
				if(value==1)continue;
				int keyLength=key.length();
				
				if(wantedSize.containsKey(keyLength)) {
					//업데이트를 확인
					List<String> list=wantedSize.get(keyLength);
					if(list.size()==0) {
						
						list.add(key);
						
					}else {
						String zeroString=list.get(0);
						int zeroValue=map.get(zeroString);
						
						if(zeroValue==value) {
							list.add(key);
						}else if(value>zeroValue){
							list.clear();
							list.add(key);
						}
						
						
					}
					
				}
				
			}
			
			List<String> answerList=new ArrayList<String>();
			for(int key : wantedSize.keySet()) {
				List<String> values=wantedSize.get(key);
				answerList.addAll(values);
			}
			
			String answer[]=answerList.stream()
									  .sorted((a,b)->{
										  return a.compareTo(b);
									  })
									  .toArray(String[]::new);
			System.out.println(Arrays.toString(answer));
			return answer;
			
		}
		
		public void dfs(char orderchars[],char select[],int start,int depth) {
			
		if(depth>0&& depth<=orderchars.length) {
			
			//depth만큼 복사
			char copy[]=Arrays.copyOf(select, depth);
			Arrays.sort(copy);
			String copyString=new String(copy);
			map.merge(copyString,1 , (a,b)->a+b);
			//System.out.println(copyString);
			if(depth==orderchars.length) {
				return;
			}
			
		}
			
			
		for(int i=start; i<orderchars.length; i++) {
			select[depth]=orderchars[i];
			dfs(orderchars,select,i+1,depth+1);
		}
			
		}
}
