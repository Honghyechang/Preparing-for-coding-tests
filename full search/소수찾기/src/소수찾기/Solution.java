package 소수찾기;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	List<String> collaboration=new ArrayList<String>();

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		int n=s.solution("17");
//		System.out.println(n);
//	}
//	
	public int solution(String numbers) {
		
		recurison("",numbers);
		int result=decimalCheck();
		
		return result;
	}
	
	public int decimalCheck() {
		
		int count=0;
		int decimalCount=0;
		for(int i=0; i<collaboration.size(); i++) {
			int n=Integer.parseInt(collaboration.get(i));
			decimalCount=0;
			
			for(int j=1; j<=n; j++) {
				if(n%j==0)decimalCount++;
			}
			
			if(decimalCount==2)count++;
			
		}
		return count;
	}
	public void recurison(String prefix, String remaining) {
		if(remaining.length()==0)return;
		
		
		for(int i=0; i<remaining.length(); i++) {
			String newPrefix=prefix+remaining.substring(i,i+1);
			String newRemaining=remaining.substring(0,i)+remaining.substring(i+1);
			
			//System.out.println("newPrefix"+newPrefix);
			String col=new String(newPrefix);
			while(col.matches("^0.*")) {
				col=col.replaceAll("^0","");
				//System.out.println("대체");
			
			}
			
			//System.out.println("col"+col);
			
			if(!col.equals("") && !collaboration.contains(col)) {
				collaboration.add(col);
			}
			
			recurison(newPrefix,newRemaining);
		}
	}

}
