package 하샤드수;

public class Solution {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		int n=s.sum(133);
//		System.out.println(n);
//
//	}

	  public boolean solution(int x) {
		  int m=sum(x);
		   
		  return x%m==0;
	   }
	  
	  public int sum(int x) {
		  
		  int cul=0;
		  while(x>0) {
			  
			  int m=x%10;
			  int n=x/10;
			  
			  cul+=m;
			  System.out.println(m);
			  x=n;
		  }
		  
		
		  return cul;
		  
	  }
	  
	  
}
