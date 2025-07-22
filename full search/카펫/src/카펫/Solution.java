package 카펫;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Solution s= new Solution();
int result[]=s.solution(24, 24);
System.out.println(Arrays.toString(result));
	}

	public int[] solution(int brown, int yellow) {
		List<Integer> nlist=new ArrayList<>();
		List<Integer> mlist=new ArrayList<>();
		
		int size=brown+yellow;
		
		for(int i=1; i<=size; i++) {
			if(size%i==0) {
				int m=i;
				int n=size/i;
				
				if(nlist.contains(m)) {
					break;
				}
				
				nlist.add(n);
				mlist.add(m);
				
			}
		}
		int result[]=new int[2];
		
		for(int i=0; i<nlist.size(); i++) {
			System.out.println(nlist.get(i)+","+mlist.get(i));
			int n=nlist.get(i); int m=mlist.get(i);
			
			if( (2*n) +((m-2)*2)==brown) {
				result[0]=n;
				result[1]=m;
				break;
			}
		}
		
		return result;
		
	}
}
