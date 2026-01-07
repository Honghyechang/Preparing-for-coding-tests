package day4;

import java.util.Arrays;

public class Solution3 {
//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	Solution3 s=new Solution3();
//	boolean result=s.solution(new String[] {"119","91239","1192304"});
//	System.out.println(result);
//
//}

public boolean solution(String phone_book[]) {

	Arrays.sort(phone_book);
	System.out.println(Arrays.toString(phone_book));
	for(int i=0; i<phone_book.length-1; i++) {
		if(phone_book[i+1].startsWith(phone_book[i]))return false;
}
	return true;

}
}
