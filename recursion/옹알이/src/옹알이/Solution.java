package 옹알이;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	//"aya", "ye", "woo", "ma"
	public int solution(String[] babbling) {
		int sum=0;
		for(String str : babbling) {
			if(recurison(str)) {
				sum++;
			}
		}
        return  sum;
    }

	
	public boolean recurison(String str) {
		//벗어나는경우
		if(str.isEmpty()) {
			return true;
		}
		
		if(str.startsWith("aya")) {
			return recurison(str.substring(3));
		}
		if(str.startsWith("ye")) {
			return recurison(str.substring(2));
		}
		if(str.startsWith("woo")) {
			return recurison(str.substring(3));
		}
		if(str.startsWith("ma")) {
			return recurison(str.substring(2));
		}
		
		return false;
		
	}
	
	
	
}
