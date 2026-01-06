package day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution7 {
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Solution7 s=new Solution7();
	String orders[]= {"XYZ", "XWY", "WXA"};
	int course[]= {2,3,4};
	String []arr=s.solution(orders,course);
	
System.out.println(Arrays.toString(arr));
}

public String[] solution(String orders[],int course[]) {
	
	List<String> answerList=new ArrayList<String>();

	for(int i=0; i<course.length; i++) {
		int wantLength=course[i];
		Map<String,Integer> maps=new HashMap<String, Integer>();
		
		for(String order : orders) {
			//System.out.println("order : "+order);
			if(order.length()<wantLength)continue;
			collaboration(order.toCharArray(),wantLength,0,new char[wantLength],maps,0);
		}
		
		List<String> maxList=new ArrayList<String>();
		int max=Integer.MIN_VALUE;
		
		for(String key: maps.keySet()) {
			int value=maps.get(key);
			if(value<2) {
				continue;
			}
			
			if(value==max) {
				maxList.add(key);
			}else if(max<value) {
				maxList.clear();
				maxList.add(key);
				max=value;
			}
		}
		answerList.addAll(maxList);
	
	}
	
	String answer[]=answerList.stream()
							  .sorted((a,b)->a.compareTo(b))
							  .toArray(String[]::new);
	//System.out.println(Arrays.toString(answer));
	return answer;
	
	
}

public void collaboration(char[] order,int wantLength, int selectIndex, char selectchars[],Map<String,Integer> maps , int start) {
	
	if(selectIndex==wantLength) {
		char[]clone=selectchars.clone();
		Arrays.sort(clone);
		String result=new String(clone);
//		System.out.println(result);
		maps.merge(result, 1, (a,b)->a+b);
							
		return;
	}
	
	
	for(int i=start; i<order.length; i++) {
		selectchars[selectIndex]=order[i];
		collaboration(order,wantLength,selectIndex+1,selectchars,maps,i+1);
	}
	
}


}
