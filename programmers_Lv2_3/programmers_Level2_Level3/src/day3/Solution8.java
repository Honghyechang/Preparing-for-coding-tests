package day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution8 {
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	String infos[]=new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
	String query[]=new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
	
	Solution8 s=new Solution8();
	int [] result=s.solution(infos, query);
	//System.out.println(Arrays.toString(result));

	}
	
	public int[] solution(String [] info,String [] query) {

		//가능한 조합 모드구하고, 그에 맞는 info 의 점수 를 리스트로 넣기,
		//이 리스트에서 특정값보다 큰 , 적절한 리스트의 인덱스를 찾기;
		
	
		
//		for(int i=0; i<languageList.size(); i++) {
//
//			for(int j=0; j<jobList.size(); j++) {
//
//				for(int k=0; k<carrerList.size(); k++) {
//
//					for(int d=0; d<foodList.size(); d++) {
//						
//						System.out.println(languageList.get(i)+jobList.get(j)+carrerList.get(k)+foodList.get(d));
//					}
//				}
//			}
//		}
		
		//collaboration(lists,0,new String[lists.size()],info);
		
		//info에 대해서 본인 되는 경우에 숫자를 추가하기
		List<String> languageList=new ArrayList<String>();
		List<String> jobList=new ArrayList<String>();
		List<String> carrerList=new ArrayList<String>();
		List<String> foodList=new ArrayList<String>();
		
		languageList.add("*");
		jobList.add("*");
		carrerList.add("*");
		foodList.add("*");
		for(String infoStr : info) {
			
			String split[]=infoStr.split(" ");
			getSplitCollaboration(split,0,new String[split.length-1]);
		}
//		for(String infoStr : info) {
//			String split[]=infoStr.split(" ");
//			//System.out.println(split[0] + " , "+split[1] + " , "+split[2] + " , "+split[3] + " , ");
//			languageList.add(split[0]);
//			jobList.add(split[1]);
//			carrerList.add(split[2]);
//			foodList.add(split[3]);
//			
//			for(int i=0; i<languageList.size(); i++) {
//			
//						for(int j=0; j<jobList.size(); j++) {
//			
//							for(int k=0; k<carrerList.size(); k++) {
//			
//								for(int d=0; d<foodList.size(); d++) {
//									String key=languageList.get(i)+jobList.get(j)+carrerList.get(k)+foodList.get(d);
//									int value=Integer.parseInt(split[4]);
//									if(maps.containsKey(key)) {
//										maps.get(key).add(value);
//									}else {
//										List<Integer> st=new ArrayList<Integer>();
//										st.add(value);
//										maps.put(key, st);
//									}
//								}
//							}
//						}
//					}
//			
//			languageList.remove(split[0]);
//			jobList.remove(split[1]);
//			carrerList.remove(split[2]);
//			foodList.remove(split[3]);
//		}
		
		
		
		
		
//		for(String key : maps.keySet()) {
//			System.out.println(maps.get(key));
//		}
		
		
		int answer[]=new int[query.length];
		for(int i=0; i<query.length; i++) {
			String queryStr=query[i];
			queryStr=queryStr.replaceAll("and\\s", "");
			String[] split=queryStr.split(" ");
			String key=split[0]+split[1]+split[2]+split[3];
			key=key.replaceAll("\\-", "*");
			int seek=Integer.parseInt(split[4]);
			//System.out.println("key : "+key);
			
			if(!maps.containsKey(key)) {
				answer[i]=0;
				continue;
			}
			List<Integer> list=maps.get(key);
			int arr[]=list.stream()
						  .mapToInt(n->n.intValue())
						  .sorted()
						  .toArray();
			
						  
			int n=binarySeek(arr,seek);
			answer[i]=n;
			
		}
		
		System.out.println(Arrays.toString(answer));
		
		
		
		return answer;
	}
	
	
	public void getSplitCollaboration(String split[],int index, String select[]) {
		if(index==split.length-1) {
			String key=Arrays.stream(select).collect(Collectors.joining());
			if(maps.containsKey(key)) {
				maps.get(key).add(Integer.parseInt(split[4]));
			}else {
				List<Integer> list=new ArrayList<Integer>();
				list.add(Integer.parseInt(split[4]));
				maps.put(key, list);
			}
			return;
		}
		select[index]=split[index];
		getSplitCollaboration(split,index+1,select);
		

		select[index]="*";
		getSplitCollaboration(split,index+1,select);
		
		
	}
	
	
	
	public int binarySeek(int arr[],int seek) {
		int start=0;
		int end=arr.length;
		
		//System.out.println("seek : "+seek);
		while(start<end) {
			int mid=(start+end)/2;
			if(arr[mid]>=seek) {
				end=mid;
			}else {
				start=mid+1;
			}
		
		}
		//System.out.println("start : " + start);
		//start가 가장 가까운 인덱스를 말하고, 
		return arr.length-start;
	}
	
	Map<String,List<Integer>> maps=new HashMap<String, List<Integer>>();
	
	public void collaboration(List<List<String>> lists, int index, String[] select , String [] info) {
		if(index==lists.size()) {
			match(select,info);
			return;
		}
		
		List<String> list=lists.get(index);
		for(int i=0; i<list.size(); i++) {
			select[index]=list.get(i);
			collaboration(lists,index+1,select,info);
		}
	}
	
	public void match(String select[],String[] infos) {
		String key=Arrays.stream(select).collect(Collectors.joining(""));
		List<Integer> value=new ArrayList<Integer>();
		for(String info : infos) {
			String infoSplit[]=info.split(" ");
			if((select[0].equals("*")||select[0].equals(infoSplit[0]))   && (select[1].equals("*")||select[1].equals(infoSplit[1])) && (select[2].equals("*")||select[2].equals(infoSplit[2])) && (select[3].equals("*")||select[3].equals(infoSplit[3])) ) {
				value.add(Integer.parseInt(infoSplit[4]));
			}
		}
		maps.put(key, value);
	//	System.out.println("key 저장 : "+key);
	}
	
}
