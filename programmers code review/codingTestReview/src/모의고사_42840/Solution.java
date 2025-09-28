package 모의고사_42840;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s=new Solution();
//s.solution(new int[] {1,3,2,4,2});
//	}

	public int[] solution(int answers[]) {
		
		String onePattern="12345";
		String twoPattern="12324252"; //앞에 2로 시작
		String threePattern="3311224455";
		
		StringBuilder oneSb=new StringBuilder();
		StringBuilder twoSb=new StringBuilder("2");
		StringBuilder threeSb=new StringBuilder();
		
		int questionCount=answers.length;
		
		int answerCount[]=new int[] {0,0,0};
		
		while(oneSb.length()<questionCount) {
			oneSb.append(onePattern);
		}
		
		while(twoSb.length()<questionCount) {
			twoSb.append(twoPattern);
		}
		
		while(threeSb.length()<questionCount) {
			threeSb.append(threePattern);
		}
		int oneArr[]=oneSb.toString().chars()
						.map((i)->i-'0')
		                .toArray();
		
		int twoArr[]=twoSb.toString().chars()
				.map((i)->i-'0')
                .toArray();
		
		int threeArr[]=threeSb.toString().chars()
				.map((i)->i-'0')
                .toArray();

	
		for(int i=0; i<answers.length; i++) {
			int answer=answers[i];
			
			if(oneArr[i]==answer) {
				answerCount[0]+=1;
			}
			if(twoArr[i]==answer) {
				answerCount[1]+=1;
			}
			if(threeArr[i]==answer) {
				answerCount[2]+=1;
			}
		}
		
		System.out.println(Arrays.toString(answerCount));
		
		int max=Integer.MIN_VALUE;
		List<Integer> answerList=new ArrayList<Integer>();
		for(int i=0; i<3; i++) {
			int n=answerCount[i];
			if(n>max) {
			answerList.clear();
			answerList.add(i+1);
			max=n;
			}else if(n==max) {
				answerList.add(i+1);
			}
		}
		//System.out.println(answerList.toString());
		
		int answer[]=answerList.stream()
							   .mapToInt(i->i.intValue())
							   .toArray();
		//System.out.println(Arrays.toString(answer));
	
	
	return answer;
	}
}
