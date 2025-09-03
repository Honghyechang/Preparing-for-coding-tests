package 투포인터;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		Solution s=new Solution();
//		s.solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
//	}
	
	public int[] solution(String[] gems) {
		
		Set<String> typeSet=new HashSet<String>();
		for(int i=0; i<gems.length; i++) {
			String s=gems[i];
			typeSet.add(s);
		}
		
		int typeCount=typeSet.size();
		
		//2개의 포인터
		int sp=0;
		int ep=0;
		
		Map<String,Integer> allTypeMap=new HashMap<String,Integer>();
		
		
		
		int answerEp=100000;
		int answerSp=-1;
		
		while(ep<gems.length) {
			//ep를 확장한다.
			String epValue=gems[ep];
			if(allTypeMap.containsKey(epValue)) {
				allTypeMap.put(epValue, allTypeMap.get(epValue)+1);
			}else {
				allTypeMap.put(epValue, 1);
			}
			
			if(allTypeMap.keySet().size()==typeCount) {
				//sp확장
				while(allTypeMap.keySet().size()==typeCount) {
					//System.out.println(ep-sp);
					//System.out.println(answerEp-answerSp);
					if(ep-sp<answerEp-answerSp) {
						System.out.println("1");
						answerEp=ep;
						answerSp=sp;
					}
					String spValue=gems[sp];
					if(allTypeMap.containsKey(spValue)) {
						allTypeMap.put(spValue, allTypeMap.get(spValue)-1);
						if(allTypeMap.get(spValue)==0) {
							allTypeMap.remove(spValue);
						}
					}
					sp++;
				}
				
			}
			ep++;
			
			
		}
		
		
	
		
		
        int[] answer = new int[] {answerSp+1,answerEp+1};
    	System.out.println(answer[0]+","+answer[1]);
		
        return answer;
    }

}
