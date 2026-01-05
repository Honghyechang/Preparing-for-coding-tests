package day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution4 {
	public static void main(String[] args) {
	// TODO Auto-generated method stub
Solution4 s=new Solution4();
s.solution(new int[] {1,3,2,4,2});
}

public int[] solution(int answers[]) {
	
	int[] pattern1=new int[] {1,2,3,4,5};
	int[] pattern2=new int[] {2,1,2,3,2,4,2,5};
	int[] pattern3=new int[] {3,3,1,1,2,2,4,4,5,5};
	
	int count1=0;
	int count2=0;
	int count3=0;
	for(int i=0; i<answers.length; i++)
	{
		int p1=i%pattern1.length;
		int p2=i%pattern2.length;
		int p3=i%pattern3.length;
		
		if(answers[i]==pattern1[p1]) {
			count1++;
		}
		if(answers[i]==pattern2[p2]) {
			count2++;
		}if(answers[i]==pattern3[p3]) {
			count3++;
		}
		
	}
	
	Map<Integer,Integer> maps=new HashMap<Integer, Integer>();
	maps.put(1, count1);	maps.put(2, count2);	maps.put(3, count3);
	
	int max=Integer.MIN_VALUE;
	List<Integer> answerList=new ArrayList<Integer>();
	
	for(int key : maps.keySet()) {
		int value=maps.get(key);
		if(max==value) {
			answerList.add(key);
		}
		
		if(max<value) {
			max=value;
			answerList.clear();
			answerList.add(key);
		}
	}
	
	Collections.sort(answerList);
	int answer[]=answerList.stream().mapToInt(i->i.intValue()).toArray();
	System.out.println(Arrays.toString(answer));
	return answer;
	
}

}
