package 전화번호목록;
import java.util.Arrays;
public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//Solution s=new Solution();
//boolean result=s.solution(new String[] {"119","91239","1192304"});
//System.out.println(result);
//		
//		
//	}

	public boolean solution(String phone_book[]) {
		
		Arrays.sort(phone_book);
		
		for(int i=0; i<phone_book.length-1;i++) {
			if(phone_book[i+1].startsWith(phone_book[i])) return false;
		}
		return true;
		
		
	}
	
//	public boolean recurison(String phone_book[],int currnetIndex) {
//		
//		if(phone_book.length==currnetIndex) {
//			return true;
//		}
//		
//		String currnet=phone_book[currnetIndex];
//		
//		for(int i=0; i<phone_book.length; i++) {
//			
//			if(i==currnetIndex) continue;
//			String next=phone_book[i];
//			
//			if(next.length()>=currnet.length() &&  next.startsWith(currnet)) {
//				return false;
//			}
//		}
//	
//		return recurison(phone_book,currnetIndex+1);
//	}



}
