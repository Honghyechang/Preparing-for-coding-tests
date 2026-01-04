package day1;

public class Solution7 {
	public static void main(String[] args) {
	// TODO Auto-generated method stub

	Solution7 s=new Solution7();
	s.solution("a");
}
int min=Integer.MAX_VALUE;
public int solution(String s) {
	if(s.length()==1) {
		return 1;
	}
	for(int i=1; i<s.length(); i++) {
		int n=packageString(s,i);
		if(n<min) {
			min=n;
		}
	}
	//System.out.println(min);
	return min;
}

public int packageString(String string,int length) {

	int n=string.length()/length;
	int remainIndex=n*length;//realString이후 남은 나머지
	String realString=string.substring(0,remainIndex);
	String remainString=string.substring(remainIndex);
	
	int number=1;
	StringBuilder sb=new StringBuilder();
	String before="";
	for(int i=0; i<realString.length(); i=i+length) {

		String cut=realString.substring(i,i+length);
		//System.out.println(cut);
		if(cut.equals(before)) {
			number++;
		}else {
			if(number!=1) {
				sb.append(Integer.toString(number));
			}
			sb.append(before);
			
			
			//초기화
			number=1;
			before=cut;
		}
	}
	
	if(number!=1) {
		sb.append(Integer.toString(number));
	}
	sb.append(before);

	
	//나머지 추가
	sb.append(remainString);
	//System.out.println("length : "+length + " , result : "+sb.toString());
	return sb.length();
	
	
	
}
}
