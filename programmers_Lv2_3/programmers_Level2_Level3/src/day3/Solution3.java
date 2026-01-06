package day3;

import java.util.Arrays;

public class Solution3 {
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Solution3 s=new Solution3();
	int m=s.solution(new int[]{3,0,6,1,5});
	System.out.println(m);
}

public int solution(int citations[]) {

	//h의 최대값을 찾고 적절한 h 찾기 아닌가?
	
	
	
	
	int start=0;
	int end=citations.length+1;
	
	
	//작은수부터 큰것을 찾아가는것이라고 하면,
	//가능하 최대값을 구하는거니까, 작은 수부터 돼? 하고 큰값으로 이동하는것
	
	while(start+1<end) {
		int mid=(start+end)/2;
		if(isPossible(citations,mid)) {
			//s이동하기
			start=mid;
			System.out.println(start+" : start 업데이트");
		}
		else{
			//e이동하기
			end=mid;
		}
	}
	
	System.out.println(start);
	return start;
	
}

public boolean isPossible(int citations[],int h) {
	int big=0;
	int small=0;
	for(int n : citations) {
		if(h>=n) {
			small++;
		}
		if(h<=n) {
			big++;
		}
	}
	if(big>=h && small<=h) {
		return true;
	}else {
		return false;
	}
	
}

}
