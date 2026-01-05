package day2;

import java.util.HashSet;
import java.util.Set;

public class Solution7 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Solution7 s=new Solution7();
	s.solution("011");
//	System.out.println(Integer.parseInt("011"));
	//System.out.println(s.isSosu(7));
}

public int solution(String numbers) {
	char[] numberChar=numbers.toCharArray();
	getCollaboration(numberChar,new boolean[numberChar.length],0,new char[numberChar.length]);
	
	int count=0;
	for(int n : sets) {
		//System.out.println(n);
		if(isSosu(n)) {
			//System.out.println("소수"+n);
			count++;
		}
	}
	System.out.println(count);
	return count;
}

public boolean isSosu(int n) {
	if(n==1||n==0)return false;
	if(n==2)return true;
	
	for(int i=2; i<=Math.sqrt(n); i++) {
		if(n%i==0) return false;
	}
	return true;
}

Set<Integer> sets=new HashSet<Integer>();
public void getCollaboration(char[] numbers, boolean used[], int selectIndex, char[] selectChar) {
	
	StringBuilder sb=new StringBuilder();
	for(int i=0; i<selectIndex; i++) {
	sb.append(selectChar[i]);	
	}
	if(!sb.toString().equals("")) {
		sets.add(Integer.parseInt(sb.toString()));
		//System.out.println(Integer.parseInt(sb.toString()));
	}
	
	if(selectIndex==numbers.length) {
		return;
	}
	
	for(int i=0; i<numbers.length; i++) {
		if(!used[i]) {
			selectChar[selectIndex]=numbers[i];
			used[i]=true;
			getCollaboration(numbers,used,selectIndex+1,selectChar);
			used[i]=false;
		}
	}
	
}

}
