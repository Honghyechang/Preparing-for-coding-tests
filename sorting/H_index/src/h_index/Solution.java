package h_index;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		int m=s.solution(new int[]{3,0,6,1,5});
		System.out.println(m);
	}

	public int solution(int citations[]) {
		
		int max=max(citations);
		
		int h=Integer.MIN_VALUE;
		if(max==0) {
			return 0;
		}
		for(int i=0; i<max; i++) {
			int count=0;
			for(int j=0; j<citations.length; j++) {
				if(i<=citations[j]) {
					count++;
				}
			}
			
			if(i<=count) {
				h=i;
			}
		}
		return h;
	}
	
	public int max(int arr[]) {
		int max=Integer.MIN_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		return max;
	}
}
