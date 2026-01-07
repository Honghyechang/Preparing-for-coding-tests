package day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	Solution2 s=new Solution2();
	
	s.solution(25,new int[] {2,14,11,21,17}, 2);
}

	public int solution(int distance, int rocks[],int n) {

		
		//거리를 구하고, 큰것부터 작은거로 나눠서, 이거 가능해? n이하로 없앨 수 있어? 있으면 줄여가기
		int start=0;
		int end=1000000001;
		
		List<Integer> rocksList=new ArrayList<Integer>();
		rocksList.add(0);
		for(int r : rocks) {
			rocksList.add(r);
		}
		rocksList.add(distance);
		
		rocks=rocksList.stream()
					   .sorted()
					   .mapToInt(i->i.intValue())
					   .toArray();
		//System.out.println(Arrays.toString(rocks));
		
		while(start+1<end) {
			int mid=(start+end)/2;
			if(isPossible(n,mid,rocks)) {
				start=mid;;
			}else {
				end=mid;
			}
		}
		
		System.out.println(start);
		return start;
	}
	
	
	public boolean isPossible(int n, int mid, int rocks[]) {
		int removeCount=0;
		//돌을 지웟을때 가능하게끔 만들기
		//문제가 생기는 것만 지워보자
		int last=0;
		for(int i=1; i<rocks.length; i++) {
			int current=rocks[i];
		if(current-last<mid) {
			removeCount++;
			continue;
		}
		last=current;
		
		}
		return n>=removeCount? true : false;
	}
	
	
}
