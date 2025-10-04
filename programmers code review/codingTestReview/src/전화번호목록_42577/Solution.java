package 전화번호목록_42577;

import java.util.Arrays;

public class Solution {

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution s=new Solution();
//	boolean result=s.solution(new String[] {"119","91239","1192304"});
//	System.out.println(result);
//
//}

public boolean solution(String phone_book[]) {
	
	for(int i=0; i<phone_book.length; i++) {
		phone_book[i]=phone_book[i].replaceAll(" ", "");
	}
	
	Arrays.sort(phone_book);
	
	for(int i=0; i<phone_book.length; i++) {
		if(i!=phone_book.length-1) {
			if(phone_book[i+1].startsWith(phone_book[i])) {
				return false;
			}
		}
	}
	return true;
	
}
	
	

}
