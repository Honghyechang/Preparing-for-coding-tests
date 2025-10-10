package 보석쇼핑_67258;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//
//	Solution s=new Solution();
//	s.solution(new String[] {"AA", "AB", "AC", "AA", "AC"});
//}

	public int[] solution(String[] gems) {
		//map의 키셋에
		//종류의 키들이 모두 포함되있다면 성공
		Set<String> products=new HashSet<String>();
		for(String product : gems) {
			products.add(product);
		}
		int start=0;
		int end=0;
		
		int answerStart=0;
		int answerEnd=gems.length-1;
		
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put(gems[start], 1);
		
		while(start<gems.length) {
			
			//조건에 안맞으면 end를 확장하고
			//조건에 맞는다면 정답 기록하고 s를 확장한다.
			if(map.keySet().size()==products.size()) {
				//조건에 맞는거
				if(answerEnd-answerStart > end-start) {
					answerEnd=end;
					answerStart=start;
				}
				//현재꺼 삭제하고 s늘리기
				String gem=gems[start];
				map.put(gem, map.get(gem)-1);
				if(map.get(gem)==0) {
					map.remove(gem);
				}
				
				start++;
				
			}else {
				//조건에 맞지 않다면
				end=end+1;
				if(end>=gems.length)break;
				String gem=gems[end];
				map.merge(gem, 1, (a,b)->a+b);
				
			}
			
			
		}
		
		System.out.println("start : "+(answerStart+1)+" end : "+(answerEnd+1));
		return new int[] {answerStart+1,answerEnd+1};
	}

}
