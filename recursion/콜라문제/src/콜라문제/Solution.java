package 콜라문제;

class Solution {
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Solution s=new Solution();
//		s.recurison(3, 1, 20, 0, 0);
//
//	}
	
	//a 개 빈병을 가져다 주면 마트에서 b개를 준다, 빈병 n개일 떄, 몇개를 받을 수 있는가?
    public int solution(int a, int b, int n) {
        return recurison(a,b,n,0,0);
    }
    
    //a가 2  b가 1 n이 20 remain 0 sum 0
    public int recurison(int a, int b ,int n, int remainSum,int sum) {
    	
    	
    	if(n/a < 1) {
    		
    		if((n+remainSum)/a<1) 
    		{
    			System.out.println("n : "+n+" remainSum : "+remainSum+" sum : "+sum+"일때 종료");
    	    	
    			return sum;
    		}
    		
    		return recurison(a,b,n+remainSum,0,sum);
        	
    	}
    	
  
     	int newN=n/a*b;
    	int newRemain=n%a;
    	sum+=newN;
    	System.out.println("n : "+n+" remainSum : "+remainSum+" sum : "+sum);
    	
    	return recurison(a,b,newN,newRemain+remainSum,sum);
    	
    }
}
